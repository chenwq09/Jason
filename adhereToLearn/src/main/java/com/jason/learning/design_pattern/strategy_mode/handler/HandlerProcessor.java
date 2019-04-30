package com.jason.learning.design_pattern.strategy_mode.handler;

import com.jason.learning.design_pattern.strategy_mode.type.ClassScaner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mf
 * @ClassName HandlerProcessor
 * @Description 注册所有handler
 * @date 2019-04-26 13:58
 * @Version 1.0
 */
@Component
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE = "com.jason.learning.design_pattern.strategy_mode.handler.biz";

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String ,Class> handlerMap = new HashMap<>();
        ClassScaner.scan(HANDLER_PACKAGE,HandlerType.class).forEach(clazz ->{
            String type = clazz.getAnnotation(HandlerType.class).value();
            handlerMap.put(type,clazz);
        });

        HandlerContext context = new HandlerContext(handlerMap);
        beanFactory.registerSingleton(HandlerContext.class.getName(),context);

    }
}
