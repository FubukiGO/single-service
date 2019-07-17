package com.ygg.debt.common.aspect;

import com.ygg.debt.common.exception.BusinessException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author akhan
 * @description
 * @date 10:56 2018-12-18
 */
@Aspect
@Component
public class UpdateByIdCheckAspect {

    private Logger logger = LoggerFactory.getLogger(UpdateByIdCheckAspect.class);

    public UpdateByIdCheckAspect() {
        logger.info("初始化数据更新检查切面类...");
    }

    @Pointcut("execution(* com.baomidou.mybatisplus.service.IService.updateById(..))")
    public void pointCutUpd() {
    }

    @AfterReturning(pointcut = "pointCutUpd()", returning = "ret")
    public void checkHandler(JoinPoint jp, Object ret) {
        boolean result = (boolean) ret;
        if (!result) {
            throw new BusinessException("系统繁忙,请稍后再试");
        }
    }
}
