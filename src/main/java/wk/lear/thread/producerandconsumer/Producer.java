/*
 * cf
 * FileName: Producer.java
 * Author:   BM
 * Date:     2019-04-02 23:53:46
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-02 23:53:46> <version> <desc> <source>
 *
 */

package wk.lear.thread.producerandconsumer;

/**
 * Created by bm on 18-4-2.
 */
public class Producer {

    private LockObj lockObj;

    public Producer(LockObj lockObj){
        this.lockObj =lockObj;
    }
    public void setProductList(){
        try {
            synchronized (lockObj) {
                Thread.currentThread().sleep(100);
                if (null == lockObj.getProductValue()) {
                    String productValue="no:"+System.nanoTime();
                    lockObj.setProductValue(productValue);
                    System.out.println("product_add"+productValue);
                } else {
                    lockObj.wait();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
