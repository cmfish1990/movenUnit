/*
 * cf
 * FileName: MyThread.java
 * Author:   BM
 * Date:     2019-04-03 17:04:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-03 17:04:41> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.locks.reentrantlockcondition;

public class MyThread extends Thread {

    private  MyService myService;
    public  MyThread(MyService myService){
        this.myService=myService;
    }

    @Override
    public void run() {
       myService.serviceRun();
    }
}
