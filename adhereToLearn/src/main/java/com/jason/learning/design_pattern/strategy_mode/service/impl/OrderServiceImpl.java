package com.jason.learning.design_pattern.strategy_mode.service.impl;

import com.jason.learning.design_pattern.strategy_mode.model.OrderDto;
import com.jason.learning.design_pattern.strategy_mode.service.IOrderService;
import com.jason.learning.design_pattern.strategy_mode.type.OrderType;
import org.springframework.stereotype.Service;

/**
 * @author mf
 * @ClassName OrderServiceImpl
 * @Description 普通order实现
 * @date 2019-04-26 11:44
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements IOrderService {


    @Override
    public String handle(OrderDto dto) {
        String type = dto.getType();
        if(OrderType.COMMON_ORDER.getCode().equals(type)){
            // TODO deal common order
            return "处理普通订单";
        }else if(OrderType.GROUP_BUY_ORDER.getCode().equals(type)){
            // TODO deal group buy order
            return "处理团购订单";
        }else if(OrderType.PROMOTION_ORDER.getCode().equals(type)){
            // TODO deal promotion order
            return "处理促销订单";
        }else{
            // TODO do other things
        }
        return null;
    }
}
