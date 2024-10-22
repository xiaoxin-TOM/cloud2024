package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

public interface PayService {
    public int add (Pay pay);
    public int update (Pay pay);
    public int delete (Long id);
    public Pay getPayById(Long id);
    public List<Pay> getPayList();
}
