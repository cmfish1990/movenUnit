/*
 * Copyright (C),2015-2019.
 * FileName: MyObjectRun.java
 * Author:   BM
 * Date:     2019-12-16 22:47:02
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-12-16 22:47:02> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.thread.suspend;

/**
 * Created by bm on 17-12-16.
 */
public class MyObjectRun {
    public static void main(String[] args) {
        try {
            final MyObject obj = new MyObject();
            Thread a = new Thread() {
                public void run() {
                    obj.setValue("b", "b");
                }
            };
            a.setName("a");
            a.start();
            Thread.sleep(1000);
            obj.printStr();
        }
        catch (InterruptedException e){

        }
    }
}
