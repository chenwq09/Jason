package com.jason.learning.design_pattern.strategy_mode.service;

import com.jason.learning.design_pattern.strategy_mode.model.OrderDto;

/**
 *
 */
public interface IOrderService {

    String handle(OrderDto dto);

}
