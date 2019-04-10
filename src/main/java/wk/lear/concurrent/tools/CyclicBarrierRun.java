/*
 * cf
 * FileName: CyclicBarrierTest01.java
 * Author:   BM
 * Date:     2019-03-25 22:41:29
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-25 22:41:29> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.tools;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by bm on 18-3-25.
 * 2019/04/19
 */
public class CyclicBarrierRun {


    public static void main(String[] args) {
    test01();
     //   test02();
        System.out.println("helloworld");
    }

     public  static void test02(){
        final  CyclicBarrier cyclicBarrier02= new  CyclicBarrier(2,new c());
         Thread threadA = new Thread() {
             @Override
             public void run() {
                 try {
                     System.out.println(Thread.currentThread().getId() + "__" + 1.0);
                     Thread.sleep(1000);
                     cyclicBarrier02.await();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }
                 System.out.println(Thread.currentThread().getId() + "__" + 1.1);
             }
         };
         threadA.start();
         try {
             cyclicBarrier02.await();
         } catch (Exception e) {
             e.printStackTrace();
         }

         System.out.println(Thread.currentThread().getId() + "__" + 2);

     }
     static class  c implements Runnable{

         @Override
         public void run() {
             System.out.println("thread c " +3);
         }
     }
    /**
     * 基础的测试0
     */
    public static   void test01() {
        final CyclicBarrier cyclicBarrier01 = new CyclicBarrier(4);
        for(int i=0;i<4;i++) {
            Thread threadA = new Thread() {
                @Override
                public void run() {
                    try {
                        long time=System.currentTimeMillis();
                        System.out.println("Thread  before name ："+Thread.currentThread().getName()+"_"+Thread.currentThread().getId()+"  ,"+time);
                        cyclicBarrier01.await();
                        System.out.println("Thread  after name ："+Thread.currentThread().getName()+"_"+Thread.currentThread().getId()+"  ,"+time);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            };
            threadA.start();
        }
//        try {
//            cyclicBarrier01.await();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getId() + "__" + 2);
    }
}
