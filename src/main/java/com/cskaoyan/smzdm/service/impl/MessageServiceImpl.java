package com.cskaoyan.smzdm.service.impl;

import com.cskaoyan.smzdm.bean.vo.ConversationVO;
import com.cskaoyan.smzdm.bean.vo.MessageVO;
import com.cskaoyan.smzdm.mapper.MessageMapper;
import com.cskaoyan.smzdm.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<ConversationVO> findAllConversationVO(String userId) {
        List<ConversationVO> conversationVOs = new ArrayList<>();
        //将所有的消息查出来，自己选择性进行封装
        List<MessageVO> messageVOs = messageMapper.selectAllMessageVO(userId);
        //将消息根据conversationId进行分组
        Map<String,List<MessageVO>> map = new HashMap<>();
        if(messageVOs != null){
            for (MessageVO vo : messageVOs) {
                String conversationId = vo.getMessage().getConversationId();
                if(map.get(conversationId) != null){
                    map.get(conversationId).add(vo);
                }else {
                    List<MessageVO> list = new ArrayList<>();
                    list.add(vo);
                    map.put(conversationId,list);
                }
            }
        }
        //将conversation中的未读消息数量统计
        // 将conversation中的最新消息赋值给ConversationVO中的每一个元素
        for(Map.Entry<String,List<MessageVO>> pair : map.entrySet()){
            ConversationVO conversationVO = new ConversationVO();
            List<MessageVO> msgVOs = pair.getValue();
            int unRead = 0;
            int count = 0;
            MessageVO last = null;
            for(MessageVO msgVO : msgVOs){
                Integer unread = msgVO.getMessage().getUnread();
                if(unread == 0){
                    unRead++;
                }
                if(count  == 0){
                    last = msgVO;
                }else if(msgVO.getMessage().getCreatedDate().compareTo(last.getMessage().getCreatedDate()) > 0){
                    last = msgVO;
                }
                count++;
            }
            conversationVO.setCount(count);
            conversationVO.setConversation(last.getMessage());
            conversationVO.setUnread(unRead);
            conversationVO.setUser(last.getUser());

            conversationVOs.add(conversationVO);
        }

         return conversationVOs;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
    public List<MessageVO> findAllMessageVO(String userId, String conversationId) {

        List<MessageVO> messageVOS = messageMapper.selectMessageVOByCid(userId, conversationId);
        //将详细读取的消息的状态设置成已读
        messageMapper.updateMessageByCid(userId,conversationId);
        return messageVOS;
    }
}
