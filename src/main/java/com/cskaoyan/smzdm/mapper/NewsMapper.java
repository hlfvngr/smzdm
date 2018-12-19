package com.cskaoyan.smzdm.mapper;

import com.cskaoyan.smzdm.bean.News;
import com.cskaoyan.smzdm.bean.vo.NewsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper {

    NewsVO selectNewsById(String newsId);

    List<NewsVO> selectAllNewsVO();

    int insert(NewsVO newsVO);

    int selectCommentCountByNewsId(String newsId);

    int updateCommentCountByNewsId(@Param("commentCount")Integer commentCount, @Param("newsId")String newsId);

    int isExist(@Param("newsId") String newsId, @Param("userId") String userId);

    int addSupport(@Param("newsId")String newsId, @Param("userId")String userId);

    int deleteSupport(@Param("newsId")String newsId, @Param("userId") String userId);

    int updateLikeCountByNewsId(@Param("likeCount")Integer likeCount,@Param("newsId")String newsId);

    int selectLikeCountByNewsId(String newsId);
}
