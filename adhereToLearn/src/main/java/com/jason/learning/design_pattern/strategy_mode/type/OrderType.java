package com.jason.learning.design_pattern.strategy_mode.type;

/**
 * 订单类型枚举
 */
public enum OrderType {

    COMMON_ORDER("1","普通订单"),GROUP_BUY_ORDER("2","团购订单"),PROMOTION_ORDER("3","促销订单");

    private String code;

    private String name;

    OrderType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
