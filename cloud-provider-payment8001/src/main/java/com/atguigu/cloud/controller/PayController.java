package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDto;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import com.atguigu.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PayController {
    @Resource
    PayService payService;

    @PostMapping("/pay/add")
    public ResultData<Integer> add(@RequestBody Pay pay){
        int i = payService.add(pay);
        new ResultData<>();
        ResultData<Integer> resultData;
        if( i > 0){
            resultData = ResultData.success(i);
        }else{
            resultData = ResultData.fail(ReturnCodeEnum.RC500.getCode(),ReturnCodeEnum.RC500.getMsg());
        }
        return resultData;
    }

    @DeleteMapping("/pay/delete/{id}")
    public ResultData<Integer> delete(@PathVariable("id") Long id){
        ResultData<Integer> resultData;
        int i = payService.delete(id);
        if(i > 0){
            resultData = ResultData.success(i);
        }else{
            resultData = ResultData.fail(ReturnCodeEnum.RC500.getCode(),ReturnCodeEnum.RC500.getMsg());
        }
        return resultData;
    }

    @PutMapping("/pay/update")
    public ResultData<Integer> update(@RequestBody PayDto payDto){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDto,pay);
        ResultData<Integer> resultData;
        int i = payService.update(pay);
        if(i > 0){
            resultData = ResultData.success(i);
        }else{
            resultData = ResultData.fail(ReturnCodeEnum.RC500.getCode(),ReturnCodeEnum.RC500.getMsg());
        }
        return resultData;
    }

    @GetMapping("/pay/get/{id}")
    public ResultData<Pay> queryById(@PathVariable Long id){
        if(id<0){
            throw new RuntimeException("查询不能为负数");
        }
        return ResultData.success(payService.getPayById(id));
    }

    @GetMapping("/pay/getAll")
    public ResultData<List<Pay>> queryAll(){
        return ResultData.success(payService.getPayList());
    }
}
