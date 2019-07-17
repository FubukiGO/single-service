package com.ygg.debt.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: akhan
 * @Description: 参数非空检查注解
 * @Date: 15:53 2019-07-02
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestRequire {

    /**
     * 请求当前接口所需要的参数,多个以小写的逗号隔开
     *
     * @return
     */
    public String require() default "";

    /**
     * 传递参数的对象类型
     */
    public Class<?> parameter() default Object.class;
}