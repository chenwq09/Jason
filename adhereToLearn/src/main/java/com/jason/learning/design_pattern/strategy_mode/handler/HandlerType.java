package com.jason.learning.design_pattern.strategy_mode.handler;

import java.lang.annotation.*;

/**
 * 自定义注解：handlerType
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {

    String value();
}
