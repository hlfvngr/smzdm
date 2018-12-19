package com.cskaoyan.smzdm.mapper;

import com.cskaoyan.smzdm.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    boolean insert(User user);

    User selectUserByNameAndPwd(User user);

    User selectUserByName(String name);

    User selectUserById(String userId);
}
