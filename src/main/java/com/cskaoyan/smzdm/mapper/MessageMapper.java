package com.cskaoyan.smzdm.mapper;

import com.cskaoyan.smzdm.bean.vo.ConversationVO;
import com.cskaoyan.smzdm.bean.vo.MessageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageMapper {

    int insertMessage(MessageVO messageVO);

    List<MessageVO> selectAllMessageVO(String userId);

    List<MessageVO> selectMessageVOByCid(@Param("userId") String userId, @Param("conversationId") String conversationId);

    boolean updateMessageByCid(@Param("userId")String userId, @Param("conversationId")String conversationId);
}
