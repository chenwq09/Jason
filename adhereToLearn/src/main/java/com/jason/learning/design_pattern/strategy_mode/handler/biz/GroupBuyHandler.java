package com.jason.learning.design_pattern.strategy_mode.handler.biz;

import com.jason.learning.design_pattern.strategy_mode.handler.AbstractHandler;
import com.jason.learning.design_pattern.strategy_mode.handler.HandlerType;
import com.jason.learning.design_pattern.strategy_mode.model.OrderDto;
import org.springframework.stereotype.Component;

/**
 * @author mf
 * @ClassName GroupBuyHandler
 * @Description TODO
 * @date 2019-04-26 13:44
 * @Version 1.0
 */
@Component
@HandlerType(value = "2")
public class GroupBuyHandler extends AbstractHandler {

    @Override
    public String handle(OrderDto dto) {
        // TODO do group bug order
        return "团购订单";
    }
}
