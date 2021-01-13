package com.ccarlosf.service;

import com.ccarlosf.pojo.bo.SubmitOrderBO;

public interface OrderService {

    /**
     * 用于创建订单相关信息
     *
     * @param submitOrderBO
     */
    public String createOrder(SubmitOrderBO submitOrderBO);

}
