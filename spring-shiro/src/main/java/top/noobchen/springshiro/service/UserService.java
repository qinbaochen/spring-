package top.noobchen.springshiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.noobchen.springshiro.entry.User;
import top.noobchen.springshiro.mapper.UserMapper;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User findUserByName(String name){
        return userMapper.findUserByName(name);
    }
}
