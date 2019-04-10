/*
 * cf
 * FileName: LockObj.java
 * Author:   BM
 * Date:     2019-04-02 23:55:23
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-02 23:55:23> <version> <desc> <source>
 *
 */

package wk.lear.thread.producerandconsumer;

import java.util.List;

/**
 * Created by bm on 18-4-2.
 */
public class LockObj {
    private  String lockName;

    private List<String> productList;

    private String productValue;

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    public List<String> getProductList() {
        return productList;
    }

    public void setProductList(List<String> productList) {
        this.productList = productList;
    }

    public String getProductValue() {
        return productValue;
    }

    public void setProductValue(String productValue) {
        this.productValue = productValue;
    }
}
