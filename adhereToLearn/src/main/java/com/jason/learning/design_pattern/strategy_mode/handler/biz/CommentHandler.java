package com.jason.learning.design_pattern.strategy_mode.handler.biz;

import com.jason.learning.design_pattern.strategy_mode.handler.AbstractHandler;
import com.jason.learning.design_pattern.strategy_mode.handler.HandlerType;
import com.jason.learning.design_pattern.strategy_mode.model.OrderDto;
import org.springframework.stereotype.Component;

/**
 * @author mf
 * @ClassName CommentHandler
 * @Description 普通订单
 * @date 2019-04-26 13:40
 * @Version 1.0
 */
@Component
@HandlerType(value = "1")
public class CommentHandler extends AbstractHandler {

    @Override
    public String handle(OrderDto dto) {
        //TODO deal common order
        return "普通订单";
    }
}
