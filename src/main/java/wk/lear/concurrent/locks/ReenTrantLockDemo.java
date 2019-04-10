/*
 * cf
 * FileName: ReenTrantLockDemo.java
 * Author:   BM
 * Date:     2019-04-16 22:41:39
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-16 22:41:39> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bm on 18-4-16.
 */
public class ReenTrantLockDemo {

    public static void main(String[] args) throws Exception{
        test4();
    }
    public static void test3() throws Exception{
        final Lock lock=new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" before interrupted.");
                lock.lock();
                System.out.println(Thread.currentThread().getName()+" interrupted.");
               lock.unlock();
            }
        });
        t1.start();
       Thread.sleep(1000);

     //  t1.interrupt();
     //   Thread.sleep(1000000);
    }

    public static void test4() throws Exception{
        final Lock lock=new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    System.out.println("before:  ");
                    lock.lockInterruptibly();
                    System.out.println("after :");
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+" interrupted.");
                }
            }
        });
        t1.start();
       // Thread.sleep(1000);
   //     t1.interrupt();
       // Thread.sleep(1000000);
    }

}
