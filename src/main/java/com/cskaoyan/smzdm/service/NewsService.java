package com.cskaoyan.smzdm.service;

import com.cskaoyan.smzdm.bean.vo.NewsVO;

import java.util.List;

public interface NewsService {

    List<NewsVO> findAllNews();

    NewsVO findNewsById(String newsId);

    boolean addNews(NewsVO newsVO);

    boolean isClick(String newsId, String userId);

    boolean like(String newsId, String id);

    boolean dislike(String newsId, String id);
}
