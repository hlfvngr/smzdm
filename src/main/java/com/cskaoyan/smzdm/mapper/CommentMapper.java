package com.cskaoyan.smzdm.mapper;

import com.cskaoyan.smzdm.bean.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<CommentVO> selectCommentByNewsId(String newsId);

    int insertComment(CommentVO commentVO);
}
