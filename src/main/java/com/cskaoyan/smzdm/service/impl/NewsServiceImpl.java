package com.cskaoyan.smzdm.service.impl;

import com.cskaoyan.smzdm.bean.vo.NewsVO;
import com.cskaoyan.smzdm.mapper.NewsMapper;
import com.cskaoyan.smzdm.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

     @Autowired
    NewsMapper newsMapper;

    @Override
    public NewsVO findNewsById(String newsId) {
        return newsMapper.selectNewsById(newsId);
    }

    @Override
    public boolean addNews(NewsVO newsVO) {
        return newsMapper.insert(newsVO) != 0;
    }

    @Override
    public boolean isClick(String newsId, String userId) {
        return newsMapper.isExist(newsId,userId) != 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
    public boolean like(String newsId, String userId) {
        //再点赞的时候要更新相应朋友圈的点赞数
        int i = newsMapper.addSupport(newsId, userId);
        if(i == 0){
            return false;
        }
        int likeCount = newsMapper.selectLikeCountByNewsId(newsId);
        int j = newsMapper.updateLikeCountByNewsId(likeCount + 1, newsId);
        if(j == 0){
            return false;
        }
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
    public boolean dislike(String newsId, String userId) {
        //再点赞的时候要更新相应朋友圈的点赞数
        int i = newsMapper.deleteSupport(newsId, userId);
        if(i == 0){
            return false;
        }
        int likeCount = newsMapper.selectLikeCountByNewsId(newsId);
        int j = newsMapper.updateLikeCountByNewsId(likeCount - 1, newsId);
        if(j == 0){
            return false;
        }
        return true;
    }

    @Override
    public List<NewsVO> findAllNews() {
        return newsMapper.selectAllNewsVO();
    }

}
