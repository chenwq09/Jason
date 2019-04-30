package com.jason.learning.design_pattern.strategy_mode.handler;

import com.jason.learning.design_pattern.strategy_mode.model.OrderDto;

/**
 * @author mf
 * @ClassName AbstractHandler
 * @Description
 * @date 2019-04-26 13:15
 * @Version 1.0
 */
public abstract class AbstractHandler {

    abstract public String handle(OrderDto dto);
}
