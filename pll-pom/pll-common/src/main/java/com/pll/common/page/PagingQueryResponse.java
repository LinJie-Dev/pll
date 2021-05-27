package com.pll.common.page;

import java.io.Serializable;
import java.util.List;

/**
 * 伯乐定制化分页查询
 *
 * @author 张云和
 * @date 2020/5/28 16:39 上午
 */
public class PagingQueryResponse<T, F> implements Serializable {
    /**
     * 总条数
     */
    private Integer total;
    /**
     * 各行数据
     */
    private List<T> rows;
    /**
     * 底部合计
     */
    private F footer;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public F getFooter() {
        return footer;
    }

    public void setFooter(F footer) {
        this.footer = footer;
    }
}
