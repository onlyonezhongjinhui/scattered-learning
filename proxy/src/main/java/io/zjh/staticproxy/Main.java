package io.zjh.staticproxy;

import io.zjh.UserMapper;
import io.zjh.entity.User;
import io.zjh.metric.CrudMetric;

public class Main {
    public static void main(String[] args) {
        UserMapper userMapper = new UserMapper();
        UserMapperProxy userMapperProxy = new UserMapperProxy(userMapper);
        User user = new User("1", "sky", 18);
        userMapperProxy.insert(user);
        user.setName("人皇sky");
        userMapperProxy.update(user);
        userMapperProxy.selectById(user.getId());
        userMapperProxy.selectAll();
        userMapperProxy.deleteById(user.getId());
        CrudMetric.metric();
    }
}
