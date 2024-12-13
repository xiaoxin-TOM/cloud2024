package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDto;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
public class OrderController {

    public static final String url = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/pay/add")
    public ResultData addOrd(@RequestBody PayDto payDto){
        return restTemplate.postForObject(url+"/pay/add",payDto,ResultData.class);
    }

    @GetMapping("/consumer/get/{id}")
    public ResultData getOrd(@PathVariable String id){
//        return restTemplate.postForObject(url+"/pay/get/",id,ResultData.class);
        return restTemplate.getForObject(url+"/pay/get/"+id,ResultData.class);
    }


}
