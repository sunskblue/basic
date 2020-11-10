package com.sunskblue.basicserver.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author sunshaokang
 * @date Created in 2020/11/6 11:13 上午
 * Description：
 */
@Getter
@Setter
public class PageDTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_PAGE_SIZE = 10;
    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 页面容量
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 总条数
     */
    private Long count;

    private List<T> list;


    public void init() {
        this.pageNum = 1;
        this.pageSize = 10;
    }

    public PageDTO() {
    }

    public PageDTO(Integer pageNum, Integer pageSize, Long count, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.count = count;
        this.list = list;
        setTotalPage();
    }

    public Integer getTotalPage(long totalPage) {
        setTotalPage();
        return this.totalPage;
    }

    public void setTotalPage() {
        if (count == null) {
            return;
        }
        if (count == 0) {
            this.totalPage = 0;
        }
        this.totalPage = (int) (count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
    }


    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PageReqDTO{");
        sb.append("pageNum=").append(pageNum);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", count=").append(count);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }

}
