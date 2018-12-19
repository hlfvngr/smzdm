package com.cskaoyan.smzdm.service;

import com.cskaoyan.smzdm.bean.vo.CommentVO;

import java.util.List;

public interface CommentService {

    List<CommentVO> findCommentByNewsId(String newsId);

    boolean addCommentVO(CommentVO commentVO);
}
