package com.zgp.controller;

import com.zgp.entity.CommonResult;
import com.zgp.entity.Payment;
import com.zgp.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/Payment/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        if (result>0){
              return new CommonResult(200,"插入数据库成功",result);
        }else {
            return new CommonResult(400,"插入数据库失败");
        }
    }

    @GetMapping(value = "/Payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        if (paymentById!=null){
            return new CommonResult(200,"查询成功",paymentById);
        }else {
            return new CommonResult(400,"查询失败",null);
        }

    }


}
