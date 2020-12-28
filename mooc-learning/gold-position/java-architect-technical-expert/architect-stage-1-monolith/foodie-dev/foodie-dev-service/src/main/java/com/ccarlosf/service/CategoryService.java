package com.ccarlosf.service;

import com.ccarlosf.pojo.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 查询所有一级分类
     *
     * @return
     */
    public List<Category> queryAllRootLevelCat();


}
