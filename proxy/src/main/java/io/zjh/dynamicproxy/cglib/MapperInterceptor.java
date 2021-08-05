package io.zjh.dynamicproxy.cglib;

import io.zjh.metric.CrudMetric;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MapperInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
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
        return methodProxy.invokeSuper(o, objects);
    }

}
