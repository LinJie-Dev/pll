package com.pll.elasticsearch.model.doc;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Classname BaseUserDoc
 * @Description 基础用户文档
 * @Date 2021/5/12 15:19
 * @Author 林杰
 */
@Data
@Document(indexName = "#{baseUserDocConfig.indexName:base_user}", type = "#{baseUserDocConfig.type:base_user}")
public class BaseUserDoc {

    /**
     * 用户名
     */
    @Id
    @Field(store = true, type = FieldType.Keyword)
    private String userName;
    /**
     * 用户年龄
     */
    @Field(store = true, type = FieldType.Keyword)
    private String userAge;
}
