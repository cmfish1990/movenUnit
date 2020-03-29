/*
 * cf
 * FileName: Consumer.java
 * Author:   BM
 * Date:     2019-04-02 23:54:15
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-02 23:54:15> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.thread.producerandconsumer;

/**
 * Created by bm on 18-4-2.
 */
public class Consumer {

    private LockObj lockObj;

   public Consumer(LockObj lockObj){
        this.lockObj =lockObj;
    }
    public void getProduct(){
       try {
           synchronized (lockObj) {
                  Thread.currentThread().sleep(100);
               if (null == lockObj.getProductValue()) {
                   lockObj.notify();
               } else {
                   System.out.println("consumer_get"+lockObj.getProductValue());
                   lockObj.setProductValue(null);
               }
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }
}
