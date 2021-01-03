package com.ccarlosf.mapper;

import com.ccarlosf.pojo.vo.ItemCommentVO;
import com.ccarlosf.pojo.vo.SearchItemsVO;
import com.ccarlosf.pojo.vo.ShopcartVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom {

    public List<ItemCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);

    public List<SearchItemsVO> searchItems(@Param("paramsMap") Map<String, Object> map);

    public List<SearchItemsVO> searchItemsByThirdCat(@Param("paramsMap") Map<String, Object> map);

    // TODO  指定类型
    public List<ShopcartVO> queryItemsBySpecIds(@Param("paramsList") List specIdsList);
}