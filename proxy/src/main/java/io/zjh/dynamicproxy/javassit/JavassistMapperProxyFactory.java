package io.zjh.dynamicproxy.javassit;

import io.zjh.IUserMapper;
import io.zjh.UserMapper;
import javassist.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class JavassistMapperProxyFactory {

    public static IUserMapper newInstance(UserMapper userMapper) throws NotFoundException, CannotCompileException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassPool pool = ClassPool.getDefault();

        CtClass proxyCtClass = pool.makeClass("io.zjh.dynamicproxy.javassit.JavassistMapperProxy");

        // TODO 设置接口（找不到接口报错了）
        CtClass interfaceClass = pool.get("io.zjh.IUserMapper");

        proxyCtClass.setInterfaces(new CtClass[]{interfaceClass});

        // 设置属性
        CtField ctField = CtField.make("private io.zjh.UserMapper userMapper", proxyCtClass);
        proxyCtClass.addField(ctField);

        // 设置构造函数
        CtClass userMapperCtlClass = pool.get("io.zjh.UserMapper");
        CtClass[] arrays = new CtClass[]{userMapperCtlClass};
        CtConstructor ctConstructor = CtNewConstructor.make(arrays, null, CtNewConstructor.PASS_NONE, null, null, proxyCtClass);
        ctConstructor.setBody("{this.userMapper = $1;}");
        proxyCtClass.addConstructor(ctConstructor);

        // 设置方法
        CtMethod insertCtMethod = CtMethod.make("public void insert(User user) {}", proxyCtClass);
        insertCtMethod.setBody("CrudMetric.increaseInsert();");
        proxyCtClass.addMethod(insertCtMethod);

        CtMethod updateCtMethod = CtMethod.make("public void update(User user) {}", proxyCtClass);
        updateCtMethod.setBody("CrudMetric.increaseUpdate();");
        proxyCtClass.addMethod(updateCtMethod);

        CtMethod deleteByIdCtMethod = CtMethod.make("public void deleteById(String id) {}", proxyCtClass);
        deleteByIdCtMethod.setBody("CrudMetric.increaseDelete();");
        proxyCtClass.addMethod(deleteByIdCtMethod);

        CtMethod selectByIdCtMethod = CtMethod.make("public void selectById(String id) {}", proxyCtClass);
        selectByIdCtMethod.setBody("CrudMetric.increaseSelect();");
        proxyCtClass.addMethod(selectByIdCtMethod);

        CtMethod selectAllCtMethod = CtMethod.make("public List<User> selectAll() {}", proxyCtClass);
        selectAllCtMethod.setBody("CrudMetric.increaseSelect();");
        proxyCtClass.addMethod(selectAllCtMethod);

        Class proxyClass = proxyCtClass.toClass();
        Constructor constructor = proxyClass.getConstructor(UserMapper.class);
        return (IUserMapper) constructor.newInstance(userMapper);
    }
}
