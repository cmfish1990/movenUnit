/*
 * cf
 * FileName: Page.java
 * Author:   BM
 * Date:     2019-04-03 13:44:37
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-03 13:44:37> <version> <desc> <source>
 *
 */

package wk.utils;

import java.util.List;

public class Page<T>  {

    /**
     * 当前页码
     */
    private int pageIndex;
    /**
     * 当前页的真实记录数
     */
    private int pageSize;
    /**
     * 总页数
     */
    private int pages;

    /**
     * 总记录数
     */
    private int count;

    private List<T> list;
    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
         if(pageSize<=0){
             return 0;
         }
         else return count/pageSize+1;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
