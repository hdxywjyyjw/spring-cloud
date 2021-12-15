package com.xu.service;
import com.xu.mapper.UserMapper;
import com.xu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper1;

    public User queryById(Long id) {
        return userMapper1.findById(id);
    }
}