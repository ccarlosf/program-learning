package com.ccarlos.distributedemo.service;

import com.ccarlos.distributedemo.dao.OrderItemMapper;
import com.ccarlos.distributedemo.dao.OrderMapper;
import com.ccarlos.distributedemo.dao.ProductMapper;
import com.ccarlos.distributedemo.model.Order;
import com.ccarlos.distributedemo.model.OrderItem;
import com.ccarlos.distributedemo.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
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
    @Autowired
    private PlatformTransactionManager platformTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;

    // 程序判读，商品超卖
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

    // update行锁，商品超卖
   /* @Transactional(rollbackFor = Exception.class)
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
    }*/

    // synchronized 商品超卖
    // synchronized 加在方法上，还是不起作用，原因：前一个线程事务还没提交，
    // 第二个线程就开始读取数据，解决办法，手动控制事务，锁释放时，也要保证事务提交
 /*   @Transactional(rollbackFor = Exception.class)
    public synchronized Integer createOrder() throws Exception {
        // synchronized 加在方法上，还是不起作用，原因：前一个线程事务还没提交，
        // 第二个线程就开始读取数据，解决办法，手动控制事务，锁释放时，也要保证事务提交
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

        //检索商品的库存
        //如果商品库存为负数，抛出异常

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

    // 手动控制事务，锁释放时，也要保证事务提交
//    @Transactional(rollbackFor = Exception.class)
    public synchronized Integer createOrder() throws Exception {
        TransactionStatus transaction = platformTransactionManager.getTransaction(transactionDefinition);
        Product product = productMapper.selectByPrimaryKey(purchaseProductId);
        if (product == null) {
            platformTransactionManager.rollback(transaction);
            throw new Exception("购买商品：" + purchaseProductId + "不存在");
        }

        //商品当前库存
        Integer currentCount = product.getCount();
        System.out.println(Thread.currentThread().getName() + "库存数：" + currentCount);
        //校验库存
        if (purchaseProductNum > currentCount) {
            platformTransactionManager.rollback(transaction);
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

        //检索商品的库存
        //如果商品库存为负数，抛出异常

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
        platformTransactionManager.commit(transaction);
        return order.getId();
    }
    

}
