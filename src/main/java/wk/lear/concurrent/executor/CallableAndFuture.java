/*
 * cf
 * FileName: CallableAndFuture.java
 * Author:   BM
 * Date:     2019-01-18 00:54:35
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-01-18 00:54:35> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.executor;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class CallableAndFuture {
 
        public static void main(String[] args) {
              ExecutorService threadPool = Executors. newFixedThreadPool(10);
              CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(threadPool);
 
               for (int i = 0; i < 10; i++) {
                      final int seq = i;
                     System. out.println("开始提交第" + seq + "个任务");
                     completionService.submit( new Callable<Integer>() {
 
                            @Override
                            public Integer call() throws Exception {
                                  Thread. sleep(new Random().nextInt(5000));
                                   return seq;
                           }
                     });
              }
 
               for (int i = 0; i < 10; i++) {
                      try {
                            // 取出并移除表示下一个已完成任务的 Future，如果目前不存在这样的任务，则等待。
                           Integer seq = completionService.take().get();
                           System. out.println("第" + seq + "个任务返回");
                     } catch (InterruptedException e) {
                           e.printStackTrace();
                     } catch (ExecutionException e) {
                           e.printStackTrace();
                     }
              }
       }
 
}