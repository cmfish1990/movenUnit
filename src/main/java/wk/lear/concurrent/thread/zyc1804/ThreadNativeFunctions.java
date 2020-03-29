/*
 * cf
 * FileName: ThreadNativeFunctions.java
 * Author:   BM
 * Date:     2019-04-01 01:21:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-01 01:21:41> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.thread.bm1804;

/**
 * 线程的一些基础方法
 */
public class ThreadNativeFunctions {
    public static void main(String[] args) {
        Thread ta=new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("===================");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        ta.start();
        try {
            ta.sleep(20000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.print("abcdeeeeee");
        System.out.println(Thread.currentThread().getName());
        System.out.println(ta.isAlive());
    }
}
