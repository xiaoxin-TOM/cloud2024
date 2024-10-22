package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDto;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PayController {
    @Resource
    PayService payService;

    @PostMapping("/pay/add")
    public String add(@RequestBody Pay pay){
        int i = payService.add(pay);
        System.out.println(pay.toString());
        return "插入返回成功值:"+i;
    }

    @DeleteMapping("/pay/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        int i = payService.delete(id);
        return "删除返回成功值:"+i;
    }

    @PutMapping("/pay/update")
    public String update(@RequestBody PayDto payDto){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDto,pay);
        int i = payService.update(pay);
        return "更新返回成功值:"+i;
    }

    @GetMapping("/pay/get/{id}")
    public String queryById(@PathVariable Long id){
        Pay pay = payService.getPayById(id);
        System.out.println(pay.toString());
        return pay.toString();
    }

    @GetMapping("/pay/getAll")
    public String queryAll(){
        return payService.getPayList().toString();
    }
}
