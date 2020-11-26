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
    private Integer currentPage;

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


//    public void init() {
//        this.currentPage = 1;
//        this.pageSize = 10;
//    }

    public PageDTO() {
    }

    public PageDTO(Integer currentPage, Integer pageSize, Long count, List<T> list) {
        this.currentPage = currentPage;
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


    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
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
        sb.append("currentPage=").append(currentPage);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", count=").append(count);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }

}
