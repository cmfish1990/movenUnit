/*
 * cf
 * FileName: ThreadPoolRun01.java
 * Author:   BM
 * Date:     2019-04-17 23:40:18
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-17 23:40:18> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bm on 18-4-17.
 */
public class ThreadPoolRun01 {

    public static void main(String[] args) {

        ExecutorService executorService=Executors.newFixedThreadPool(10);


    }
}
