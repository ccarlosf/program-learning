package com.ccarlosf.service;

import com.ccarlosf.pojo.OrderStatus;
import com.ccarlosf.pojo.bo.ShopcartBO;
import com.ccarlosf.pojo.bo.SubmitOrderBO;
import com.ccarlosf.pojo.vo.OrderVO;

import java.util.List;

public interface OrderService {

    /**
     * 用于创建订单相关信息
     *
     * @param submitOrderBO
     */
    public OrderVO createOrder(List<ShopcartBO> shopcartList, SubmitOrderBO submitOrderBO);

    /**
     * 修改订单状态
     *
     * @param orderId
     * @param orderStatus
     */
    public void updateOrderStatus(String orderId, Integer orderStatus);

    /**
     * 查询订单状态
     *
     * @param orderId
     * @return
     */
    public OrderStatus queryOrderStatusInfo(String orderId);

    /**
     * 关闭超时未支付订单
     */
    public void closeOrder();

}
