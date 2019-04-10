/*
 * cf
 * FileName: ReentrantService.java
 * Author:   BM
 * Date:     2019-04-03 16:43:30
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-03 16:43:30> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.locks.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantService {
   public ReentrantLock lock =new ReentrantLock();
    public void serviceRun(){
        System.out.println(Thread.currentThread().getName()+": lock before");
        lock.lock();
        System.out.println(Thread.currentThread().getName() + ": locking");
        lock.unlock();
        System.out.println(Thread.currentThread().getName() + ": lock end");

    }
}
