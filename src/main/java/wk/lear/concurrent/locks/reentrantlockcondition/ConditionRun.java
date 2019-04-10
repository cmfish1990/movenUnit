/*
 * cf
 * FileName: ConditionRun.java
 * Author:   BM
 * Date:     2019-04-03 17:06:07
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-03 17:06:07> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.locks.reentrantlockcondition;

public class ConditionRun {

    public static void main(String[] args) {
        MyService service=new MyService();
        MyThread ta=new MyThread(service);
        MyThread tb=new MyThread(service);
        MyThread tc=new MyThread(service);
        MyThread td=new MyThread(service);
        MyThread te=new MyThread(service);

        ta.start();

    }
}
