package com.template.springboot.redis.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageInfoVO implements Serializable {

    private long pageNo;
    private long pageSize;
    private long pageStart;
    private long pageEnd;
    private long totals;
}
