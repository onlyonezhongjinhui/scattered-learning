package io.zjh;

import io.zjh.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InnerUserMapper {

    private final Map<String, User> maps = new ConcurrentHashMap<>();

    public void insert(User user) {
        maps.put(user.getId(), user);
        System.out.println("insert : " + user);
    }

    public void update(User user) {
        maps.put(user.getId(), user);
        System.out.println("update : " + user);
    }

    public void deleteById(String id) {
        maps.remove(id);
        System.out.println("delete id : " + id);
    }

    public User selectById(String id) {
        System.out.println("select id : " + id);
        return maps.get(id);
    }

    public List<User> selectAll() {
        System.out.println("select all");
        return new ArrayList<>(maps.values());
    }

}
