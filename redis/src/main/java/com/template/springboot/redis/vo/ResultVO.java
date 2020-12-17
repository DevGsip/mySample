package com.template.springboot.redis.vo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResultVO implements Serializable {

    private String code;
    private String message;
    private Object data;

    private PageInfoVO pageInfoVO;


    public static String sucess(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode("000000");
        resultVO.setMessage("执行成功");
        resultVO.setData(data);
        return JSON.toJSONString(resultVO);
    }

    public static String sucess(Object data,PageInfoVO pageInfoVO){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode("000000");
        resultVO.setMessage("执行成功");
        resultVO.setData(data);
        resultVO.setPageInfoVO(pageInfoVO);
        return JSON.toJSONString(resultVO);
    }
}
