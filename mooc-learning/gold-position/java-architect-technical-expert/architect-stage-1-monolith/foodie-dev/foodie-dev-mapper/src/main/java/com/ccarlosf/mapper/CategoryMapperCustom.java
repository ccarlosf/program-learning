package com.ccarlosf.mapper;


import com.ccarlosf.pojo.vo.CategoryVO;

import java.util.List;

public interface CategoryMapperCustom {

    public List<CategoryVO> getSubCatList(Integer rootCatId);

}