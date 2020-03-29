/*
 * Copyright (C),2015-2019.
 * FileName: SuspendRun.java
 * Author:   BM
 * Date:     2019-12-16 22:25:56
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-12-16 22:25:56> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.thread.suspend;

/**
 * Created by bm on 17-12-16.
 */
public class SuspendRun {
    public static void main(String[] args) {
        try {
            final SynchronizedObject obj = new SynchronizedObject();
            Thread t1 = new Thread() {
                public void run() {
                    obj.print();
                }
            };
            t1.setName("a");
            t1.start();
            Thread.sleep(1000);

            Thread t2 = new Thread() {
                public void run() {
                    System.out.println("t2 start");
                    obj.print();
                    System.out.println("t2 end");
                }
            };
            t2.start();
        //    t1.resume();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
