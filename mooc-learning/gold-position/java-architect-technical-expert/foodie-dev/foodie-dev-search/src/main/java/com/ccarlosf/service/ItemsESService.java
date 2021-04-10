package com.ccarlosf.service;


import com.ccarlosf.utils.PagedGridResult;

public interface ItemsESService {

    public PagedGridResult searhItems(String keywords,
                                      String sort,
                                      Integer page,
                                      Integer pageSize);

}
