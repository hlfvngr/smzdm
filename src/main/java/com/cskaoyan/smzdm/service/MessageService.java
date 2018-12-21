package com.cskaoyan.smzdm.service;

import com.cskaoyan.smzdm.bean.vo.ConversationVO;
import com.cskaoyan.smzdm.bean.vo.MessageVO;

import java.util.List;

public interface MessageService {

    List<ConversationVO> findAllConversationVO(String userId);

    List<MessageVO> findAllMessageVO(String userId, String conversationId);

}
