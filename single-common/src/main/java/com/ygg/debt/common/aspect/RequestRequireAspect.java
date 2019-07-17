package com.ygg.debt.common.aspect;

import com.ygg.debt.common.annotation.RequestRequire;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

@Aspect
@Component
public class RequestRequireAspect {

    Logger logger = LoggerFactory.getLogger(RequestRequireAspect.class);


    public RequestRequireAspect() {
        logger.info("初始化接口参数非空判断切面类...");
    }

    @Pointcut("@annotation(com.ygg.debt.common.annotation.RequestRequire)")
    public void controllerInteceptor() {
    }

    @Around("controllerInteceptor()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        //获取注解的方法参数列表
        Object[] args = pjp.getArgs();

        //获取被注解的方法
        MethodInvocationProceedingJoinPoint mjp = (MethodInvocationProceedingJoinPoint) pjp;
        MethodSignature signature = (MethodSignature) mjp.getSignature();
        Method method = signature.getMethod();

        //获取方法上的注解
        RequestRequire require = method.getAnnotation(RequestRequire.class);

        //以防万一，将中文的逗号替换成英文的逗号
        String fieldNames = require.require().replace("，", ",");

        //从参数列表中获取参数对象
        Object parameter = null;
        for (Object pa : args) {
            //class相等表示是同一个对象
            if (pa.getClass() == require.parameter() || require.parameter().isAssignableFrom(pa.getClass())) {
                parameter = pa;
            }
        }

        String[] fields = fieldNames.split(",");
        //通过反射去和指定的属性值判断是否非空
        Class cl = parameter.getClass();

        if (Map.class.isAssignableFrom(cl)) {
            Map map = (Map) parameter;
            for (String fieldName : fields) {
                if (map.get(fieldName) == null || StringUtils.isBlank(String.valueOf(map.get(fieldName))))
                    throw new RuntimeException("参数：" + fieldName + "不允许为空");
            }
        } else {
            for (String fieldName : fields) {

                //根据属性名获取属性对象
                Field f = cl.getDeclaredField(fieldName);

                //设置可读写权限
                f.setAccessible(true);

                //获取参数值，因为我的参数都是String型所以直接强转
                String value = String.valueOf(f.get(parameter));

                //非空判断
                if (f.get(parameter) == null || !StringUtils.isNotBlank(value)) {
                    throw new RuntimeException("参数：" + fieldName + "不允许为空");
                }
            }
        }

        //如果没有报错，放行
        return pjp.proceed();
    }
}