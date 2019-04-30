package com.jason.learning.design_pattern.strategy_mode.handler.biz;

import com.jason.learning.design_pattern.strategy_mode.handler.AbstractHandler;
import com.jason.learning.design_pattern.strategy_mode.handler.HandlerType;
import com.jason.learning.design_pattern.strategy_mode.model.OrderDto;
import org.springframework.stereotype.Component;

/**
 * @author mf
 * @ClassName PromotionHandler
 * @Description TODO
 * @date 2019-04-26 13:45
 * @Version 1.0
 */
@Component
@HandlerType(value = "3")
public class PromotionHandler extends AbstractHandler {

    @Override
    public String handle(OrderDto dto) {
        // TODO do promotion order
        return "促销订单";
    }
}
