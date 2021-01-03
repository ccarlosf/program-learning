package com.ccarlosf.controller;

import com.ccarlosf.enums.PayMethod;
import com.ccarlosf.pojo.bo.SubmitOrderBO;
import com.ccarlosf.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "订单相关", tags = {"订单相关的api接口"})
@RequestMapping("orders")
@RestController
public class OrdersController extends BaseController {

    final static Logger logger = LoggerFactory.getLogger(OrdersController.class);


    @ApiOperation(value = "用户下单", notes = "用户下单", httpMethod = "POST")
    @PostMapping("/create")
    public JSONResult create(
            @RequestBody SubmitOrderBO submitOrderBO,
            HttpServletRequest request,
            HttpServletResponse response) {

        // TODO 判断
        if (submitOrderBO.getPayMethod() != PayMethod.WEIXIN.type
                && submitOrderBO.getPayMethod() != PayMethod.ALIPAY.type) {
            return JSONResult.errorMsg("支付方式不支持！");
        }

        System.out.println(submitOrderBO.toString());
        return JSONResult.ok();
    }
}
