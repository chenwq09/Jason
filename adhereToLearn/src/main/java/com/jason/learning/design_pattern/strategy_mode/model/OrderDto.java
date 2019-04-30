package com.jason.learning.design_pattern.strategy_mode.model;

import java.math.BigDecimal;

/**
 * @author mf
 * @ClassName OrderDto
 * @Description 订单
 * @date 2019-04-26 11:40
 * @Version 1.0
 */
public class OrderDto {

    private String code;

    private BigDecimal price;

    /**
     * 订单类型
     * 1.普通订单
     * 2.团购订单
     * 3.促销订单
     * 4.....
     */
    private String type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
