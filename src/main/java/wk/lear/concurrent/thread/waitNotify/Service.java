/*
 * cf
 * FileName: Service.java
 * Author:   BM
 * Date:     2019-01-07 22:25:12
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-01-07 22:25:12> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.thread.waitNotify;

/**
 * Created by bm on 18-1-7.
 */
public class Service {
    public void testWaitService(Object lock) throws Exception {
        synchronized (lock){
            System.out.println(Thread.currentThread().getName()+": wait");
            lock.wait();
        }
    }
}
