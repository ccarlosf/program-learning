package com.ccarlosf.service;


import com.ccarlosf.pojo.Carousel;

import java.util.List;

public interface CarouselService {

    /**
     * 查询所有轮播图列表
     *
     * @param isShow
     * @return
     */
    public List<Carousel> queryAll(Integer isShow);

}
