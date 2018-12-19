package com.cskaoyan.smzdm.controller;

import com.cskaoyan.smzdm.bean.Comment;
import com.cskaoyan.smzdm.bean.User;
import com.cskaoyan.smzdm.bean.vo.CommentVO;
import com.cskaoyan.smzdm.service.CommentService;
import com.cskaoyan.smzdm.service.NewsService;
import com.cskaoyan.smzdm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AjaxController {

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @Autowired
    NewsService newsService;

    @RequestMapping("/reg")
    @ResponseBody
    public Map<String,Object> register(@RequestParam("username") String name,
                                           @RequestParam("password") String password, HttpSession session){
        Map<String,Object> result = new HashMap<>();
        //验证参数是否合法
        if(password == null || password.length() < 6){
            result.put("code",1);
            result.put("msgpwd","用户不合法");
            return result;
        }
        //判断用户名是否已经被注册
       User userByName = userService.findUserByName(name);
        if(userByName != null){
            result.put("code",1);
            result.put("msgname","用户名已经被注册");
            return result;
        }

        User user = new User();
        user.setName(name);
        //将用户的的密码进行hash算法加密
        //   static String MD5_ALGORITHM = "md5";
        //   public static String SHA512_ALGORITHM = "SHA-512";
        String encryptPass = encryptByHash(password,"MD5");
        user.setPassword(encryptPass);

        boolean b = userService.register(user);
        if(b){
            User register = userService.findUserByName(user.getName());
            session.setAttribute("user",register);
            result.put("code",0);
        }else {
            result.put("code",1);
        }
        return result;
    }

    @RequestMapping("/login")
    @ResponseBody
    public Map<String,Object> login(@RequestParam("username") String name,
                                       @RequestParam("password") String password, HttpSession session){
        Map<String,Object> result = new HashMap<>();
        //验证参数是否合法
        if(password == null || password.length() < 6){
            result.put("code",1);
            result.put("msgpwd","用户不合法");
            return result;
        }

        User user = new User();
        user.setName(name);
        //将用户的的密码进行hash算法加密
        //   static String MD5_ALGORITHM = "md5";
        //   public static String SHA512_ALGORITHM = "SHA-512";
        String encryptPass = encryptByHash(password,"MD5");
        user.setPassword(encryptPass);

        User login = userService.login(user);
        if(login != null){
            session.setAttribute("user",login);
            //model.addAttribute("user",login);
            result.put("code",0);
        }else {
            result.put("code",1);
        }
        return result;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session, Model model){
        if(session != null){
            session.invalidate();
            model.addAttribute("pop",0);
        }else {
            model.addAttribute("pop",1);
        }
        return "home";
    }

    @RequestMapping("/addComment")
    public String addComment(Comment comment,HttpSession session,Model model){
        Map<String,Object> result = new HashMap<>();
        User user = (User) session.getAttribute("user");
        CommentVO commentVO = new CommentVO();
        comment.setCreatedDate(new Date());
        commentVO.setComment(comment);
        commentVO.setUser(user);

        //增加朋友圈评论
        boolean b = commentService.addCommentVO(commentVO);

        //增加完成之后需要重新查数据库显示,服务器内部跳转newsController
        return "forward:/news/" + comment.getNewsId();
    }

    @RequestMapping("/like")
    @ResponseBody
    public Map<String,Object> like(String newsId,HttpSession session,Model model){
        Map<String,Object> result = new HashMap<>();
        //判断是否已经点过赞
        User user = (User) session.getAttribute("user");
        boolean b = newsService.isClick(newsId,user.getId());
        if(b){
            result.put("code",0);
            return result;
        }
        boolean ret = newsService.like(newsId,user.getId());
        if(ret){
             result.put("code",0);
        }else {
             result.put("code",1);
        }
        return result;
    }

    @RequestMapping("/dislike")
    @ResponseBody
    public Map<String,Object> dislike(String newsId,HttpSession session,Model model){
        Map<String,Object> result = new HashMap<>();
        //判断是否已经点过赞
        User user = (User) session.getAttribute("user");
        boolean b = newsService.isClick(newsId,user.getId());
        if(!b){
            result.put("code",0);
            return result;
        }

        boolean ret = newsService.dislike(newsId,user.getId());
        if(ret){
            result.put("code",0);
        }else {
            result.put("code",1);
        }
        return result;
    }

    private String encryptByHash(String content,String algorithm) {
        try {
            //1\拿到MD5的摘要
            MessageDigest instance = MessageDigest.getInstance(algorithm);
            //content 转换成一个字节
            byte[] contentBytes = content.getBytes();
            //md5值 加密算法的过程
            byte[] digest = instance.digest(contentBytes);
            //16
            String result = byteArrayToString(digest);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private String byteArrayToString(byte[] digest) {

        StringBuffer stringBuffer = new StringBuffer();
        for (byte bt: digest)
        {
            //不使用强制转换,若bt最高位为1，强制转换会出现多余的符号位比如说：-128---ffffff80
            /*int x = (int)bt;
            System.out.println("int 型:" + x);*/
            int i = bt & 0x00FF;
            //System.out.println("与运算：" + i);
            //转换成16进制的数字
            String s = Integer.toHexString(i);
            if (s.length() == 1)
            {
                stringBuffer.append("0");//若i属于0-15，就会出现只占一位，就凑不足32位16进制数了
            }
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }
}
