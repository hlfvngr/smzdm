package com.cskaoyan.smzdm.mapper;

import com.cskaoyan.smzdm.bean.vo.MessageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    int insertMessage(MessageVO messageVO);

    List<MessageVO> selectAllMessageVO();

}
