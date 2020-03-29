/*
 * cf
 * FileName: JoinRun.java
 * Author:   BM
 * Date:     2019-04-03 00:30:27
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-03 00:30:27> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.thread.join;



/**
 * Created by bm on 18-4-3.
 */
public class JoinRun {
    public static void main(String[] args) throws  Exception{

            Thread tc = new Thread() {
                @Override
                public void run() {

                    try {
                        this.sleep(1000);
                        System.out.println("========tc01=========");
                        wait(20);
                        System.out.println("========tc02=========");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            tc.start();
            tc.yield();
        tc.join(10000);
            System.out.println("main run end");
        }
}
