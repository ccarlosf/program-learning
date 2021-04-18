package com.ccarlos.service;


import com.ccarlos.utils.PagedGridResult;

public interface ItemsESService {

    public PagedGridResult searhItems(String keywords,
                                      String sort,
                                      Integer page,
                                      Integer pageSize);

}
