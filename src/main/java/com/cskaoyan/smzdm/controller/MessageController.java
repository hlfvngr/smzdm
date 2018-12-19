package com.cskaoyan.smzdm.controller;

import com.cskaoyan.smzdm.bean.Message;
import com.cskaoyan.smzdm.bean.vo.MessageVO;
import com.cskaoyan.smzdm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping("/list")
    @ResponseBody
    public List<MessageVO> list(){
        List<MessageVO> messageVO =  messageService.findAllMessageVO();
        return messageVO;
    }
}
