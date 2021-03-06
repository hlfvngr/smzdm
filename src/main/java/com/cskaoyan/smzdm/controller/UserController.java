package com.cskaoyan.smzdm.controller;

import com.cskaoyan.smzdm.bean.Message;
import com.cskaoyan.smzdm.bean.News;
import com.cskaoyan.smzdm.bean.User;
import com.cskaoyan.smzdm.bean.vo.MessageVO;
import com.cskaoyan.smzdm.bean.vo.NewsVO;
import com.cskaoyan.smzdm.service.NewsService;
import com.cskaoyan.smzdm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    NewsService newsService;

    @RequestMapping("/{userId}")
    public String get(@PathVariable String userId, Model model){
        //也可以直接从session中直接拿
        User user = userService.findUserById(userId);
        model.addAttribute("user",user);
        return "personal";
    }

    @RequestMapping("/tosendmsg")
    public String tosendmsg(){
        return "sendmsg";
    }

    @RequestMapping("/msg/addMessage")
    @ResponseBody
    public Map<String,Object> addMessage(Message message, HttpSession session){
        Map<String,Object> result = new HashMap<>();
        User user = (User) session.getAttribute("user");
        message.setCreatedDate(new Date());
        message.setUnread(0);

        //进行比较字符串比较，然后进行拼接，作为conversationId
        //这里选择uuid进行拼接
        String toName = message.getToName();
        User userByName = userService.findUserByName(toName);
        if(userByName == null){
            return null;
        }
        String fromId = user.getId();
        message.setFromId(fromId);

        String conversationId = createConversationId(fromId,userByName.getId());

        message.setConversationId(conversationId);
        MessageVO messageVO =new MessageVO(message,user);
        //参数校验
        boolean b = userService.sendMessage(messageVO);
        if(b){
            result.put("code",0);
        }else {
            result.put("code",1);
        }
        return result;
    }

    private String createConversationId(String fromId, String toId) {
        return fromId.compareTo(toId) >= 0 ? fromId + toId : toId + fromId;
    }

    @RequestMapping("/addNews")
    @ResponseBody
    public Map<String,Object> addNews(@Valid News news, HttpSession session, BindingResult bindingResult){
        Map<String,Object> result = new HashMap<>();
        if(bindingResult.hasErrors()){
            result.put("code",1);
            return result;
        }

        User user = (User) session.getAttribute("user");
        news.setCreatedDate(new Date());
        news.setLikeCount(0);
        news.setCommentCount(0);
        NewsVO newsVO = new NewsVO(news,user);
        boolean b = newsService.addNews(newsVO);
        if(b){
            result.put("code",0);
        }else {
            result.put("code",1);
        }
        return result;
    }
}
