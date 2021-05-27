package com.pll.common.page;

import java.io.Serializable;

/**
 * 伯乐定制化查询 公共分页查询参数
 *
 * @author 张云和
 * @date 2020/5/28 16:39 上午
 */
public class PagingQueryRequest<Q, F> implements Serializable {

    /**
     * 查询参数
     */
    private Q query;
    /**
     * 过滤器参数
     */
    private F filter;
    /**
     * 分页参数
     */
    private PagingParas page = new PagingParas();

    public Q getQuery() {
        return query;
    }

    public void setQuery(Q query) {
        this.query = query;
    }

    public F getFilter() {
        return filter;
    }

    public void setFilter(F filter) {
        this.filter = filter;
    }

    public PagingParas getPage() {
        return page;
    }

    public void setPage(PagingParas page) {
        this.page = page;
    }

    /**
     * 分页参数
     */
    public static class PagingParas implements Serializable {
        /**
         * 页索引，开始于1
         */
        private Integer pageIndex = 1;
        /**
         * 页大小
         */
        private Integer pageSize = 20;
        /**
         * 排序规则，如id desc、id、createTime desc等
         */
        private String orderBy = "";

        public String getOrderBy() {
            return orderBy;
        }

        public void setOrderBy(String orderBy) {
            this.orderBy = orderBy;
        }

        public Integer getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(Integer pageIndex) {
            this.pageIndex = pageIndex;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }
    }
}
