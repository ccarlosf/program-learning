package com.ccarlosf.mapper;

import com.ccarlosf.my.mapper.MyMapper;
import com.ccarlosf.pojo.ItemsComments;

import java.util.Map;

public interface ItemsCommentsMapperCustom extends MyMapper<ItemsComments> {

    public void saveComments(Map<String, Object> map);
}