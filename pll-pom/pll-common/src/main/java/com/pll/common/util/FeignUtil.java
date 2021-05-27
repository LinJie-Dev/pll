package com.pll.common.util;


import com.pll.common.base.ResultEnum;
import com.pll.common.exception.ServiceException;

/**
 * 异常熔断处理转换工具
 *
 * @author 张云和
 * @date 2020/5/20 11:00 上午
 */
public class FeignUtil {
    private final static String TIME_OUT = "connect timed out";
    private final static String CONNECTION_REFUSED = "Connection refused";
    private final static String HYSTRIX_CIRCUIT = "Hystrix circuit short-circuited";

    /**
     * 转译Feign调用错误
     *
     * @param throwable
     * @return
     */
    public static ServiceException decodeFeignException(String interfaceName, Throwable throwable) {
        String message = throwable.getLocalizedMessage();
        if (message == null) {
            message = throwable.getClass().getName();
        } else if (message.contains(TIME_OUT)) {
            message = "连接超时";
        } else if (message.contains(CONNECTION_REFUSED)) {
            message = "连接拒绝";
        } else if (message.contains(HYSTRIX_CIRCUIT)) {
            message = "接口熔断";
        }
        return new ServiceException(ResultEnum.FAIL_BACK_ERROR.getCode(), interfaceName + "接口，" + message);
    }

}
