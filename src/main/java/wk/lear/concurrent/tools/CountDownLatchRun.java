/*
 * cf
 * FileName: CountDownLatch.java
 * Author:   BM
 * Date:     2019-03-26 00:26:28
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-26 00:26:28> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.tools;

import java.util.concurrent.CountDownLatch;

/**
 * Created by bm on 18-3-26.
 * 2019/04/19
 */
public class CountDownLatchRun {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch =new CountDownLatch(5);
        for(int i=0;i<5;i++){
            new Thread(new readNum(i,countDownLatch)).start();
        }
        countDownLatch.await();
        System.out.println("线程执行结束。。。。");
    }

    static class readNum  implements Runnable{
        private int id;
        private CountDownLatch latch;
        public readNum(int id,CountDownLatch latch){
            this.id = id;
            this.latch = latch;
        }
        @Override
        public void run() {
            synchronized (this){
                    System.out.println("id:" + id);
                try {
                        Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
                    System.out.println("线程组任务" + id + "结束，其他任务继续");

            }
        }
    }
}
