package com.pll.elasticsearch.config.doc;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 商品索引和类型配置
 * @author : 廖青松
 * @date : 2020/11/25 0:56
 */

@Component
@Data
public class BaseUserDocConfig {

    @Value("${elasticsearch.base-user.index-name:base_user}")
    private String indexName;
    @Value("${elasticsearch.base-user.type:base_user}")
    private String type;
}
