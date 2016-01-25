package com.dianrong.common.uniauth.common.bean.dto;

import java.util.List;

public class PageDto<T> {

    private int page;       // current page number, from 1
    private int pageSize;   // page size
    private int totalCount; // total record count
    private List<T> data;   // current page data

    public PageDto() {
    }

    public PageDto(int page, int pageSize, int totalCount, List<T> data) {
        this.page = page;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.data = data;
    }

    public int getTotalPage() {
        if ((pageSize <= 0) || (totalCount <= 0)) {
            return 0;
        }

        if (totalCount % pageSize == 0) {
            return totalCount / pageSize;
        } else {
            return totalCount / pageSize + 1;
        }
    }
    public PageDto setTotalPage(int totalPage) {
        return this;
    }

    public boolean hasPreviousPage() {
        return (page > 1) && (page <= getTotalPage());
    }

    public boolean hasNextPage() {
        return (page > 0) && (page < getTotalPage());
    }

    public int getPage() {
        return page;
    }

    public PageDto setPage(int page) {
        this.page = page;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageDto setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public PageDto setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    public List<T> getData() {
        return data;
    }

    public PageDto setData(List<T> data) {
        this.data = data;
        return this;
    }
}