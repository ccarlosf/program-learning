package com.ccarlos.mapper;

import com.ccarlos.my.mapper.MyMapper;
import com.ccarlos.pojo.ItemsComments;
import com.ccarlos.pojo.vo.MyCommentVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsCommentsMapperCustom extends MyMapper<ItemsComments> {

    public void saveComments(Map<String, Object> map);

    public List<MyCommentVO> queryMyComments(@Param("paramsMap") Map<String, Object> map);
}