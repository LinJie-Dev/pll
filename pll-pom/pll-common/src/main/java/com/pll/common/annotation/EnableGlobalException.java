package com.pll.common.annotation;

import com.pll.common.exception.GlobalDefaultExceptionHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启全局异常处理注解
 *
 * @author 张云和
 * @date 2020/5/23 2:26 下午
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({GlobalDefaultExceptionHandler.class})
public @interface EnableGlobalException {

}
