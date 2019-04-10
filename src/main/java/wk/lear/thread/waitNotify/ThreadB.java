/*
 * cf
 * FileName: ThreadB.java
 * Author:   BM
 * Date:     2019-01-07 21:59:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-01-07 21:59:50> <version> <desc> <source>
 *
 */

package wk.lear.thread.waitNotify;

import java.util.List;

/**
 * Created by bm on 18-1-7.
 */
public class ThreadB extends Thread {

    private List list;

    public ThreadB(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            synchronized (list) {
                for (int i = 0; i < 10; i++) {
                    list.add(i);
                    if (list.size() == 5) {
                       list.notify();
                    }

                    System.out.println("thradb:listsize" + list.size());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
