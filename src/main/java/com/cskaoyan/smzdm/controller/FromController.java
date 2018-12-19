package com.cskaoyan.smzdm.controller;

import com.cskaoyan.smzdm.bean.vo.NewsVO;
import com.cskaoyan.smzdm.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FromController {

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Autowired
    NewsService newsService;

    @RequestMapping("/")
    public String formName(HttpSession session,Model model){
        List<NewsVO> vos = newsService.findAllNews();
        if(vos != null){
            for (NewsVO vo : vos) {
                vo.setLike(vo.getNews().getLikeCount());
            }
        }
        session.getServletContext().setAttribute("vos",vos);

        session.getServletContext().setAttribute("contextPath",contextPath);
        return "home";
    }

    @RequestMapping("/{formName}")
    public String formName(@PathVariable String formName, HttpSession session, Model model){

        List<NewsVO> vos = newsService.findAllNews();
        if(vos != null){
            for (NewsVO vo : vos) {
                vo.setLike(vo.getNews().getLikeCount());
            }
        }
        session.getServletContext().setAttribute("vos",vos);

        session.getServletContext().setAttribute("contextPath",contextPath);
        return formName;
    }
}
