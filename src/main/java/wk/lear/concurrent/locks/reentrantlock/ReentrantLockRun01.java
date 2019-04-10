/*
 * cf
 * FileName: ReentrantLockRun01.java
 * Author:   BM
 * Date:     2019-04-03 16:42:25
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-03 16:42:25> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.locks.reentrantlock;

public class ReentrantLockRun01 {

    public static void main(String[] args) {
        final ReentrantService service=new ReentrantService();
        Thread ta=new Thread(){
            @Override
            public void run() {
                service.serviceRun();
            }
        };
        ta.setName("ta");
        ta.start();

        Thread tb=new Thread(){
            @Override
            public void run() {
                service.serviceRun();
            }
        };
        tb.setName("tb");
        tb.start();

        Thread tc=new Thread(){
            @Override
            public void run() {
                service.serviceRun();
            }
        };
        tc.setName("tc");
        tc.start();
    }
}
