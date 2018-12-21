package com.cskaoyan.smzdm.controller;

import com.cskaoyan.smzdm.bean.Message;
import com.cskaoyan.smzdm.bean.User;
import com.cskaoyan.smzdm.bean.vo.ConversationVO;
import com.cskaoyan.smzdm.bean.vo.MessageVO;
import com.cskaoyan.smzdm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.plugin2.message.Conversation;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/msg")
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping("/list")
    public String list(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        List<ConversationVO> conversationVOs =  messageService.findAllConversationVO(user.getId());
        model.addAttribute("conversations",conversationVOs);
        return "letter";
    }

    @RequestMapping("/detail")
    public String detail(HttpSession session, String conversationId,Model model){
        User user = (User) session.getAttribute("user");
        List<MessageVO> messageVOs = messageService.findAllMessageVO(user.getId(),conversationId);
        model.addAttribute("messages",messageVOs);
        return "letterDetail";
    }
}
