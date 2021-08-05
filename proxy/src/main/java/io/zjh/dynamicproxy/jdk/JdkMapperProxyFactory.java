package io.zjh.dynamicproxy.jdk;

import java.lang.reflect.Proxy;

@SuppressWarnings("all")
public class JdkMapperProxyFactory {

    public static <T> T newInstance(T target) {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new MapperInvocationHandler(target));
    }

}
