/*
 * Copyright (C),2015-2019.
 * FileName: SynchronizedObject.java
 * Author:   BM
 * Date:     2019-12-16 22:20:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-12-16 22:20:41> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.thread.suspend;

/**
 * Created by bm on 17-12-16.
 */
public class SynchronizedObject {

    public synchronized void print(){
        System.out.println(" synchronizdObject begin");
        if(Thread.currentThread().getName().equals("a")){
            System.out.println("a thread begin");
            Thread.currentThread().suspend();
        }
        System.out.println("synchronizdObject end");
    }
}
