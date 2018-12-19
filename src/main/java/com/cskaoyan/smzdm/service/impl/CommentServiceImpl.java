package com.cskaoyan.smzdm.service.impl;

import com.cskaoyan.smzdm.bean.vo.CommentVO;
import com.cskaoyan.smzdm.mapper.CommentMapper;
import com.cskaoyan.smzdm.mapper.NewsMapper;
import com.cskaoyan.smzdm.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    NewsMapper newsMapper;

    @Override
    public List<CommentVO> findCommentByNewsId(String newsId) {
        return commentMapper.selectCommentByNewsId(newsId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
    public boolean addCommentVO(CommentVO commentVO) {
        //增加评论之后要更新朋友圈的评论数
        int i = commentMapper.insertComment(commentVO);
        if(i == 0){
            return false;
        }
        String newsId = commentVO.getComment().getNewsId();
        int commentCount = newsMapper.selectCommentCountByNewsId(newsId);
        int j = newsMapper.updateCommentCountByNewsId((commentCount + 1),newsId);
        if(j == 0){
            return false;
        }
        return true;
    }
}
