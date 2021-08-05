package io.zjh.dynamicproxy.cglib;

import net.sf.cglib.proxy.Enhancer;

@SuppressWarnings("all")
public class CGLIBMapperProxyFactory {

    public static <T> T newInstance(Class<T> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new MapperInterceptor());
        return (T) enhancer.create();
    }

}
