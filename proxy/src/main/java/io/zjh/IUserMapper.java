package io.zjh;

import io.zjh.entity.User;

import java.util.List;

public interface IUserMapper {

    void insert(User user);

    void update(User user);

    void deleteById(String id);

    User selectById(String id);

    List<User> selectAll();

}
