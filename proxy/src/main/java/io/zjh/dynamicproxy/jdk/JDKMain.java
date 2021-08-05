package io.zjh.dynamicproxy.jdk;

import io.zjh.IUserMapper;
import io.zjh.entity.User;
import io.zjh.metric.CrudMetric;
import io.zjh.UserMapper;

public class JDKMain {
    public static void main(String[] args) {
        IUserMapper userMapper = JdkMapperProxyFactory.newInstance(new UserMapper());
        User user = new User("1", "sky", 18);
        userMapper.insert(user);
        user.setName("人皇sky");
        userMapper.update(user);
        userMapper.selectById(user.getId());
        userMapper.selectAll();
        userMapper.deleteById(user.getId());
        CrudMetric.metric();
    }
}
