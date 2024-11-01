package com.atguigu.cloud.resp;

import lombok.Data;

@Data
public class ResultData<T> {
    private String code;
    private String message;
    private T data;
    private long timestap;

    public ResultData(){
        this.timestap = System.currentTimeMillis();
    }

    public static<T> ResultData<T> success (T data){
        ResultData<T> resultData = new ResultData<>();
        resultData.setCode(ReturnCodeEnum.RC200.getCode());
        resultData.setMessage(ReturnCodeEnum.RC200.getMsg());
        resultData.setData(data);
        return resultData;
    }

    public static<T> ResultData<T> fail(String code,String message){
        ResultData<T> resultData = new ResultData<>();
        resultData.setMessage(message);
        resultData.setCode(code);
        return resultData;
    }


}
