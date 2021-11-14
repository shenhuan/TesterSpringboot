package com.vue.utils.pageParams;

import lombok.Data;

import java.util.List;

/**
 * 分页返回结果
 */
@Data
public class PageResult {
    /**
     * 当前页码
     */
    private long pageNum;
    /**
     * 每页数量
     */
    private long pageSize;
    /**
     * 记录总数
     */
    private long total;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 数据模型
     */
    private List<?> list;
}
