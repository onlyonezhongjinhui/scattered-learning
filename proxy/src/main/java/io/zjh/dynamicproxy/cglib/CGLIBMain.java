package io.zjh.dynamicproxy.cglib;

import io.zjh.InnerUserMapper;
import io.zjh.UserMapper;
import io.zjh.entity.User;
import io.zjh.metric.CrudMetric;

public class CGLIBMain {
    public static void main(String[] args) {
        InnerUserMapper innerUserMapper = CGLIBMapperProxyFactory.newInstance(InnerUserMapper.class);
        User user = new User("1", "sky", 18);
        innerUserMapper.insert(user);
        user.setName("人皇sky");
        innerUserMapper.update(user);
        innerUserMapper.selectById(user.getId());
        innerUserMapper.selectAll();
        innerUserMapper.deleteById(user.getId());
        CrudMetric.metric();

        CrudMetric.clear();
        System.out.println("*****************************************");

        UserMapper userMapper = CGLIBMapperProxyFactory.newInstance(UserMapper.class);
        userMapper.insert(user);
        user.setName("sky");
        userMapper.update(user);
        userMapper.selectById(user.getId());
        userMapper.selectAll();
        userMapper.deleteById(user.getId());
        CrudMetric.metric();
    }
}
