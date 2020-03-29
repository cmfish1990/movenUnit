/*
 * cf
 * FileName: ThreadA1.java
 * Author:   BM
 * Date:     2019-01-07 22:27:39
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-01-07 22:27:39> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.thread.waitNotify;

/**
 * Created by bm on 18-1-7.
 */
public class ThreadA1 extends  Thread {
    private Object lock;

    public ThreadA1( Object lock){
        this.lock=lock;
    }

    @Override
    public void run() {
        try {
            Service service = new Service();
            service.testWaitService(lock);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
