package com.scen.crm.page;

import java.util.List;

/**
 * 分页实体类
 *
 * @author Scen
 * @date 2018/2/17
 */
public class PageBean<T> {
    /**
     * 第几页（当前页）
     */
    private int pageNum;
    /**
     * 每页显示个数（此处固定）
     */
    private int pageSize;
    /**
     * 总记录数 查询数据库-注意条件
     */
    private int totalRecord;
    /**
     * 开始索引（计算）
     */
    private int startIndex;

    /**
     * 总分页数（计算）
     */
    private int totalPage;

    /**
     * 分页数据
     */
    private List<T> data;

    /**
     * 动态显示条
     */
    private int start;
    private int end;


    public PageBean(int pageNum, int pageSize, int totalRecord) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;

        //开始索引
        startIndex = (pageNum - 1) * pageSize;

        //总分页数
        totalPage = (totalRecord + pageSize - 1) / pageSize;
        start = 1;
        end = 10;
        if (totalPage <= end) {
            end = totalPage;
        } else {
            start = pageNum - 4;
            end = pageNum + 5;
            if (start < 1) {
                start = 1;
                end = 10;
            }
            if (end > totalPage) {
                end = totalPage;
                start = totalPage - 9;
            }
        }

    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
