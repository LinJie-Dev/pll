package com.pll.common.base;

import lombok.Getter;

/**
 * @Author 张云和
 * @Date 2018/7/12
 * @Time 11:35
 */
@Getter
public enum LogTypeEnum {

    /**
     * 打印请求入参,url
     */
    REQUEST_PARAM,

    /**
     * 打印响应结果
     */
    RESPONSE,

    /**
     * 全部
     */
    FULL
}
