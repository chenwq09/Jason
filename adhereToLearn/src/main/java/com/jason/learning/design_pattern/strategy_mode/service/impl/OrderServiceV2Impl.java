package com.jason.learning.design_pattern.strategy_mode.service.impl;

import com.jason.learning.design_pattern.strategy_mode.handler.AbstractHandler;
import com.jason.learning.design_pattern.strategy_mode.handler.HandlerContext;
import com.jason.learning.design_pattern.strategy_mode.model.OrderDto;
import com.jason.learning.design_pattern.strategy_mode.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mf
 * @ClassName OrderServiceV2Impl
 * @Description orderService v2
 * @date 2019-04-26 13:46
 * @Version 1.0
 */
@Service
public class OrderServiceV2Impl implements IOrderService {

    @Autowired
    private HandlerContext handlerContext;

    @Override
    public String handle(OrderDto dto) {
        AbstractHandler handler = handlerContext.getHandlerInstance(dto.getType());
        return handler.handle(dto);
    }
}
