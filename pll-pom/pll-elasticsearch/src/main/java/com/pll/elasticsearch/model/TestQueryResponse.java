package com.pll.elasticsearch.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Classname TestQueryResponse
 * @Description 测试查询返参实体
 * @Date 2021/5/12 11:23
 * @Author 林杰
 */
@Data
public class TestQueryResponse implements Serializable {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户年龄
     */
    private Integer userAge;
}
