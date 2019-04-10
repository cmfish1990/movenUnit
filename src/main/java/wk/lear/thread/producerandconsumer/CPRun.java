/*
 * cf
 * FileName: CPRun.java
 * Author:   BM
 * Date:     2019-04-02 23:54:30
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-02 23:54:30> <version> <desc> <source>
 *
 */

package wk.lear.thread.producerandconsumer;

/**
 * Created by bm on 18-4-2.
 */
public class CPRun {
    public static void main(String[] args) {
        LockObj lockObj=new LockObj();
         final Consumer consumer=new Consumer(lockObj);
         final Producer producer=new Producer(lockObj);
        Thread ta=new Thread(){
            @Override
            public void run() {
                while(true) {
                    consumer.getProduct();
                }
            }
        };

        Thread tb=new Thread(){
            @Override
            public void run() {
                while(true) {
                    producer.setProductList();
                }
            }
        };

        tb.start();
        ta.start();


        Thread tc=new Thread(){
            @Override
            public void run() {

                try{
                    Thread.currentThread().sleep(1000);
                    System.out.println("========tc=========");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        tc.start();
        try {
            while(tc.isAlive()) {
                tc.wait(0);
                System.out.println("========wait========");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
