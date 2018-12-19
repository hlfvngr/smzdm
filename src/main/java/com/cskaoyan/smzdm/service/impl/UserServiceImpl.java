package com.cskaoyan.smzdm.service.impl;

import com.cskaoyan.smzdm.bean.User;
import com.cskaoyan.smzdm.bean.vo.MessageVO;
import com.cskaoyan.smzdm.mapper.MessageMapper;
import com.cskaoyan.smzdm.mapper.UserMapper;
import com.cskaoyan.smzdm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    MessageMapper messageMapper;

    @Override
    public boolean register(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User login(User user) {
        return userMapper.selectUserByNameAndPwd(user);
    }

    @Override
    public User findUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    @Override
    public User findUserById(String userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public boolean sendMessage(MessageVO messageVO) {
        return messageMapper.insertMessage(messageVO) != 0;
    }
}
