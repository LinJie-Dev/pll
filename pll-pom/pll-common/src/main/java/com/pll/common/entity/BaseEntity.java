package com.pll.common.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 基础实体类
 *
 * @author zhangyunhe
 * @date 2020/6/19 10:09 上午
 */
@Data
public class BaseEntity {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除 1 有效 2 无效
     */
    private Integer valid;
}
