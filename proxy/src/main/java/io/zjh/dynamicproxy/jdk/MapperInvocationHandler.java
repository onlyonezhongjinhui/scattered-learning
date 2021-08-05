package io.zjh.dynamicproxy.jdk;

import io.zjh.metric.CrudMetric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperInvocationHandler<T> implements InvocationHandler {
    private final T target;

    public MapperInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        if (name.startsWith("insert")) {
            CrudMetric.increaseInsert();
        } else if (name.startsWith("update")) {
            CrudMetric.increaseUpdate();
        } else if (name.startsWith("delete")) {
            CrudMetric.increaseDelete();
        } else if (name.startsWith("select")) {
            CrudMetric.increaseSelect();
        }
        return method.invoke(target, args);
    }

}
