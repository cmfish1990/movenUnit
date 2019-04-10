/*
 * cf
 * FileName: ConcurrentLinkedQueue.java
 * Author:   BM
 * Date:     2019-01-16 23:32:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-01-16 23:32:13> <version> <desc> <source>
 *
 */

package wk.lear.collection.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by bm on 18-1-16.
 */
public class ConcurrentLinkedQueueDemo {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queueList=new ConcurrentLinkedQueue<String>();
        queueList.offer("hello");
        queueList.offer("world");
    }
}
