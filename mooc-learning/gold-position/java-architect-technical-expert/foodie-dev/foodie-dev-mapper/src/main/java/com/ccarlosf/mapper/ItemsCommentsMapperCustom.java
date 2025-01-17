package com.ccarlosf.mapper;

import com.ccarlosf.my.mapper.MyMapper;
import com.ccarlosf.pojo.ItemsComments;
import com.ccarlosf.pojo.vo.MyCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsCommentsMapperCustom extends MyMapper<ItemsComments> {

    public void saveComments(Map<String, Object> map);

    public List<MyCommentVO> queryMyComments(@Param("paramsMap") Map<String, Object> map);
}