/*
 * cf
 * FileName: ThreadA.java
 * Author:   BM
 * Date:     2019-01-07 21:53:37
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-01-07 21:53:37> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.thread.waitNotify;


import java.util.List;

/**
 * Created by bm on 18-1-7.
 */
public class ThreadA extends  Thread {

    private List list;
  public  ThreadA(List list){
        this.list=list;
    }
    @Override
    public void run() {
      try {
          synchronized (list) {
              if (list.size() < 5) {
                  System.out.println("Thread A:list<5 wait");
                  list.wait();
              } else {
                  System.out.println("thread A 退出");
              }
              System.out.println("thread a  end");
          }
      }
      catch (Exception e){
          e.printStackTrace();
      }
    }
}
