/*
 * Copyright (C),2015-2019.
 * FileName: DeadThreadRun.java
 * Author:   BM
 * Date:     2019-12-19 22:13:52
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-12-19 22:13:52> <version> <desc> <source>
 *
 */

package wk.lear.thread.deadthread;

/**
 * Created by bm on 17-12-19.
 */
public class DeadThreadRun {
    public static void main(String[] args) {
         try {
             DeadThread thread = new DeadThread();
             thread.setUserName("a");
             Thread ta = new Thread(thread);

             ta.start();
             Thread.sleep(100);
             thread.setUserName("b");
             Thread tb = new Thread(thread);
             tb.start();
         }
         catch (InterruptedException e){
             e.printStackTrace();
         }
    }
}
