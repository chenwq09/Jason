package com.jason.learning.design_pattern.strategy_mode.handler;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author mf
 * @ClassName HandlerContext
 * @Description
 * @date 2019-04-26 13:48
 * @Version 1.0
 */
@Component
public class HandlerContext {

    private Map<String,Class> handlerMap;

    public HandlerContext(Map<String, Class> handlerMap) {
        this.handlerMap = handlerMap;
    }


    public  AbstractHandler getHandlerInstance(String type){

        Class clazz = handlerMap.get(type);
        if(clazz == null){
            throw  new IllegalArgumentException("not fount handler for type:"+type);
        }
        return null;
    }
}
