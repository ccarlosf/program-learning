package com.ccarlos.distributedemo.service;

import com.ccarlos.distributedemo.dao.OrderItemMapper;
import com.ccarlos.distributedemo.dao.OrderMapper;
import com.ccarlos.distributedemo.dao.ProductMapper;
import com.ccarlos.distributedemo.model.Order;
import com.ccarlos.distributedemo.model.OrderItem;
import com.ccarlos.distributedemo.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@Slf4j
public class OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderItemMapper orderItemMapper;
    @Resource
    private ProductMapper productMapper;
    //购买商品id
    private int purchaseProductId = 100100;
    //购买商品数量
    private int purchaseProductNum = 1;


    /*@Transactional(rollbackFor = Exception.class)
    public Integer createOrder() throws Exception {
        Product product = productMapper.selectByPrimaryKey(purchaseProductId);
        if (product == null) {
            throw new Exception("购买商品：" + purchaseProductId + "不存在");
        }

        //商品当前库存
        Integer currentCount = product.getCount();
        System.out.println(Thread.currentThread().getName() + "库存数：" + currentCount);
        //校验库存
        if (purchaseProductNum > currentCount) {
            throw new Exception("商品" + purchaseProductId + "仅剩" + currentCount + "件，无法购买");
        }
        //计算剩余库存
        Integer leftCount = currentCount - purchaseProductNum;
        //更新库存
        product.setCount(leftCount);
        product.setUpdateTime(LocalDateTime.now());
        product.setUpdateUser("xxx");
        productMapper.updateByPrimaryKeySelective(product);

        Order order = new Order();
        order.setOrderAmount(product.getPrice().multiply(new BigDecimal(purchaseProductNum)));
        order.setOrderStatus(1);//待处理
        order.setReceiverName("xxx");
        order.setReceiverMobile("13311112222");
        order.setCreateTime(LocalDateTime.now());
        order.setCreateUser("xxx");
        order.setUpdateTime(LocalDateTime.now());
        order.setUpdateUser("xxx");
        orderMapper.insertSelective(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(order.getId());
        orderItem.setProductId(product.getId());
        orderItem.setPurchasePrice(product.getPrice());
        orderItem.setPurchaseNum(purchaseProductNum);
        orderItem.setCreateUser("xxx");
        orderItem.setCreateTime(LocalDateTime.now());
        orderItem.setUpdateTime(LocalDateTime.now());
        orderItem.setUpdateUser("xxx");
        orderItemMapper.insertSelective(orderItem);
        return order.getId();
    }*/

    @Transactional(rollbackFor = Exception.class)
    public Integer createOrder() throws Exception {
        Product product = productMapper.selectByPrimaryKey(purchaseProductId);
        if (product == null) {
            throw new Exception("购买商品：" + purchaseProductId + "不存在");
        }

        //商品当前库存
        Integer currentCount = product.getCount();
        System.out.println(Thread.currentThread().getName() + "库存数：" + currentCount);
        //校验库存
        if (purchaseProductNum > currentCount) {
            throw new Exception("商品" + purchaseProductId + "仅剩" + currentCount + "件，无法购买");
        }
        //计算剩余库存
//        Integer leftCount = currentCount - purchaseProductNum;
//        //更新库存
//        product.setCount(leftCount);
//        product.setUpdateTime(LocalDateTime.now());
//        product.setUpdateUser("xxx");
//        productMapper.updateByPrimaryKeySelective(product);


        productMapper.updateProductCount(purchaseProductNum,"xxx",
                LocalDateTime.now(),product.getId());

        Order order = new Order();
        order.setOrderAmount(product.getPrice().multiply(new BigDecimal(purchaseProductNum)));
        order.setOrderStatus(1);//待处理
        order.setReceiverName("xxx");
        order.setReceiverMobile("13311112222");
        order.setCreateTime(LocalDateTime.now());
        order.setCreateUser("xxx");
        order.setUpdateTime(LocalDateTime.now());
        order.setUpdateUser("xxx");
        orderMapper.insertSelective(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(order.getId());
        orderItem.setProductId(product.getId());
        orderItem.setPurchasePrice(product.getPrice());
        orderItem.setPurchaseNum(purchaseProductNum);
        orderItem.setCreateUser("xxx");
        orderItem.setCreateTime(LocalDateTime.now());
        orderItem.setUpdateTime(LocalDateTime.now());
        orderItem.setUpdateUser("xxx");
        orderItemMapper.insertSelective(orderItem);
        return order.getId();
    }
    

}
