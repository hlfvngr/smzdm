package com.cskaoyan.smzdm.service.impl;

import com.cskaoyan.smzdm.bean.vo.MessageVO;
import com.cskaoyan.smzdm.mapper.MessageMapper;
import com.cskaoyan.smzdm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<MessageVO> findAllMessageVO() {
        return messageMapper.selectAllMessageVO();
    }
}
