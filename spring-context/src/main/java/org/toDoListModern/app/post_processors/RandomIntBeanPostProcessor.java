package org.toDoListModern.app.post_processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Random;

@Component
public class RandomIntBeanPostProcessor implements BeanPostProcessor {

    private final Random random = new Random();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clazz = bean.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(RandomInt.class)) {
                RandomInt annotation = field.getAnnotation(RandomInt.class);
                int value = random.nextInt(annotation.max() - annotation.min() + 1) + annotation.min();
                field.setAccessible(true);
                try {
                    field.set(bean, value);
                } catch (IllegalAccessException e) {
                    throw new BeanCreationException("Can't set field", e);
                }
            }
        }
        return bean;
    }
}
