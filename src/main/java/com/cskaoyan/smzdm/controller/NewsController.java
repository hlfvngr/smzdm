package com.cskaoyan.smzdm.controller;

import com.cskaoyan.smzdm.bean.vo.CommentVO;
import com.cskaoyan.smzdm.bean.vo.NewsVO;
import com.cskaoyan.smzdm.service.CommentService;
import com.cskaoyan.smzdm.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @Autowired
    CommentService commentService;

    @RequestMapping("/{newsId}")
    public String get(@PathVariable String newsId, HttpSession session){
        Jedis jedis = new JedisPool().getResource();
        NewsVO newsVO = newsService.findNewsById(newsId);
        session.setAttribute("news",newsVO.getNews());
        session.setAttribute("owner",newsVO.getUser());

        int scard = jedis.scard(newsVO.getNews().getId() + "_like").intValue();
        newsVO.getNews().setLikeCount(scard);
        session.setAttribute("like",scard);

        List<CommentVO> commentVOs = commentService.findCommentByNewsId(newsId);
        session.setAttribute("comments",commentVOs);

        return "detail";
    }

}
