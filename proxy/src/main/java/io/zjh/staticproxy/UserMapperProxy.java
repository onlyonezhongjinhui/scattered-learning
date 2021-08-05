package io.zjh.staticproxy;

import io.zjh.IUserMapper;
import io.zjh.UserMapper;
import io.zjh.entity.User;
import io.zjh.metric.CrudMetric;

import java.util.List;

public class UserMapperProxy implements IUserMapper {

    private final UserMapper userMapper;

    public UserMapperProxy(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void insert(User user) {
        CrudMetric.increaseInsert();
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        CrudMetric.increaseUpdate();
        userMapper.update(user);
    }

    @Override
    public void deleteById(String id) {
        CrudMetric.increaseDelete();
        userMapper.deleteById(id);
    }

    @Override
    public User selectById(String id) {
        CrudMetric.increaseSelect();
        return userMapper.selectById(id);
    }

    @Override
    public List<User> selectAll() {
        CrudMetric.increaseSelect();
        return userMapper.selectAll();
    }

}
