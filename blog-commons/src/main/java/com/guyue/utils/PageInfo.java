package com.guyue.utils;

/**
 * @author tokyo
 * @date 2022/1/25
 */

public class PageInfo {
    //当前页数
    private Integer currentPage;
    //每页显示数据个数
    private Integer currentCount;
    //总条数
    private Integer totalRecord;
    //总页数
    private Integer totalPage;

    public PageInfo() {
    }

    public PageInfo(Integer currentPage, Integer currentCount, Integer totalRecord, Integer totalPage) {
        this.currentPage = currentPage;
        this.currentCount = currentCount;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(Integer currentCount) {
        this.currentCount = currentCount;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
