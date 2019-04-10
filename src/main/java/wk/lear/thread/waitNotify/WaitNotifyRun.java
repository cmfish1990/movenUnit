/*
 * cf
 * FileName: WaitNotifyRun.java
 * Author:   BM
 * Date:     2019-01-07 22:02:31
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-01-07 22:02:31> <version> <desc> <source>
 *
 */

package wk.lear.thread.waitNotify;

/**
 * Created by bm on 18-1-7.
 */
public class WaitNotifyRun {
    public static void main(String[] args) throws Exception{
//        List list=new ArrayList();
//        ThreadA ta=new ThreadA(list);
//        ThreadB tb=new ThreadB(list);
//
//
//        ta.start();
//        Thread.sleep(100);
//        tb.start();
        Object lock=new Object();
        ThreadA1 a1=new ThreadA1(lock);
        ThreadB1 b1=new ThreadB1(lock);
        a1.start();
        b1.start();
    }
}
