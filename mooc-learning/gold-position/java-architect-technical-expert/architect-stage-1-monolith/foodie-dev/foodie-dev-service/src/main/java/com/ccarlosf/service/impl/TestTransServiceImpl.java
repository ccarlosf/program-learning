package com.ccarlosf.service.impl;


import com.ccarlosf.service.StuService;
import com.ccarlosf.service.TestTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestTransServiceImpl implements TestTransService {

    @Autowired
    private StuService stuService;

    /**
     * 事务传播 - Propagation
     * REQUIRED: 使用当前的事务，如果当前没有事务，则自己新建一个事务，子方法是必须运行在一个事务中的；
     *           如果当前存在事务，则加入这个事务，成为一个整体。
     *           举例：领导没饭吃，我有钱，我会自己买了自己吃；领导有的吃，会分给你一起吃。
     * SUPPORTS: 如果当前有事务，则使用事务；如果当前没有事务，则不使用事务。
     *           举例：领导没饭吃，我也没饭吃；领导有饭吃，我也有饭吃。
     * MANDATORY: 该传播属性强制必须存在一个事务，如果不存在，则抛出异常
     *            举例：领导必须管饭，不管饭没饭吃，我就不乐意了，就不干了（抛出异常）
     * REQUIRES_NEW:
     * NOT_SUPPORTED:
     * NEVER:
     * NESTED:
     */

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testPropagationTrans() {
        stuService.saveParent();

        stuService.saveChildren();

//        int a = 1 / 0;
    }
}
