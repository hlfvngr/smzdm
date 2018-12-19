package com.cskaoyan.smzdm.service;

import com.cskaoyan.smzdm.bean.User;
import com.cskaoyan.smzdm.bean.vo.MessageVO;

public interface UserService {

    boolean register(User user);

    User login(User user);

    User findUserByName(String name);

    User findUserById(String userId);

    boolean sendMessage(MessageVO messageVO);
}
