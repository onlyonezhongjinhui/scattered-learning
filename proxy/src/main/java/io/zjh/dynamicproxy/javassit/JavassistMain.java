package io.zjh.dynamicproxy.javassit;

import io.zjh.IUserMapper;
import io.zjh.UserMapper;
import io.zjh.entity.User;
import io.zjh.metric.CrudMetric;
import javassist.CannotCompileException;
import javassist.NotFoundException;

import java.lang.reflect.InvocationTargetException;

public class JavassistMain {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, CannotCompileException, NotFoundException, InvocationTargetException {
        User user = new User("1", "sky", 18);
        user.setName("人皇sky");

        IUserMapper userMapper = JavassistMapperProxyFactory.newInstance(new UserMapper());
        userMapper.insert(user);
        user.setName("sky");
        userMapper.update(user);
        userMapper.selectById(user.getId());
        userMapper.selectAll();
        userMapper.deleteById(user.getId());
        CrudMetric.metric();
    }
}
