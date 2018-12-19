package com.cskaoyan.smzdm.service;

import com.cskaoyan.smzdm.bean.vo.MessageVO;

import java.util.List;

public interface MessageService {

    List<MessageVO> findAllMessageVO();
}
