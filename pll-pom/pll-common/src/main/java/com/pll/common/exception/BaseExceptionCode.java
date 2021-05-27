package com.pll.common.exception;

/**
 * @author 张云和
 * @date 2020/5/18 12:00 下午
 */
public interface BaseExceptionCode {

    /**
     * 错误码
     *
     * @return
     */
    String getErrorCode();

    /**
     * 错误信息
     *
     * @return
     */
    String getErrorMessage();
}
