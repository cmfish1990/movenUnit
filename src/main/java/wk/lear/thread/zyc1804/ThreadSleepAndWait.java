/*
 * cf
 * FileName: ThreadSleepAndWait.java
 * Author:   BM
 * Date:     2019-04-01 01:32:20
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-01 01:32:20> <version> <desc> <source>
 *
 */

package wk.lear.thread.bm1804;

/**
 * Created by bm on 18-4-1.
 */
public class ThreadSleepAndWait {

    public static void main(String[] args) {
        try {
            System.out.println("============before===============");
            Object obj=new Object();
            synchronized(obj){
                obj.wait();
            }
            System.out.println("==============end================");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
