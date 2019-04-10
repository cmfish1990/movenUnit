/*
 * cf
 * FileName: MyService.java
 * Author:   BM
 * Date:     2019-04-03 17:01:04
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-03 17:01:04> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.locks.reentrantlockcondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {

    private ReentrantLock lock =new ReentrantLock();
    private Condition  condition =lock.newCondition();
    public void serviceRun(){
        try {
            lock.lock();
            System.out.println("awak before");
            condition.await();
            System.out.println("awak end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
