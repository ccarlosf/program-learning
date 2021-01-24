package com.ccarlosf.service.center;


import com.ccarlosf.pojo.OrderItems;

import java.util.List;

public interface MyCommentsService {

    /**
     * 根据订单id查询关联的商品
     * @param orderId
     * @return
     */
    public List<OrderItems> queryPendingComment(String orderId);}
