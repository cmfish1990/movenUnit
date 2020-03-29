/*
 * cf
 * FileName: WaitNotifyRun02.java
 * Author:   BM
 * Date:     2019-04-02 23:32:45
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-02 23:32:45> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.thread.waitNotify;

/**
 * Created by bm on 18-4-2.
 */

/**
 * 过早通知问题
 */
public class WaitNotifyRun02 {

    private Object lockObj=new Object();

    private Boolean isNotifyEd=false;

    private Runnable Runnable01=new Runnable(){
        @Override
        public void run() {
            synchronized (lockObj){
                try {
                    System.out.println(Thread.currentThread().getName() + " :begin");
                    if(!isNotifyEd) {
                        lockObj.wait();
                    }
                    System.out.println(Thread.currentThread().getName() + " :end");
                }catch (Exception e ){
                    e.printStackTrace();
                }
            }

        }
    };

    private Runnable Runnable02=new Runnable(){
        @Override
        public void run() {
            synchronized (lockObj){
                try {
                    System.out.println(Thread.currentThread().getName() + " :begin");
                    lockObj.notify();
                    System.out.println(Thread.currentThread().getName() + " :end");
                    isNotifyEd=true;
                }catch (Exception e ){
                    e.printStackTrace();
                }
            }

        }
    };

    public static void main(String[] args) {
        WaitNotifyRun02 run=new WaitNotifyRun02();
        Thread ta=new Thread(run.Runnable01);
        ta.setName("ta");

        Thread tb=new Thread(run.Runnable02);
        tb.setName("tb");

        ta.start();
        tb.start();
    }
}
