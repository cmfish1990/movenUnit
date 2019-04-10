/*
 * cf
 * FileName: CompletionServiceRun.java
 * Author:   BM
 * Date:     2019-01-18 00:15:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-01-18 00:15:50> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.executor;

import java.util.concurrent.*;

public class CompletionServiceRun {
    public static void main(String[] args) {
       getBean();
        System.out.println("hello world");

    }
    public static Bean getBean(){
        ExecutorService pullThreadPool = Executors.newFixedThreadPool(3);
        CompletionService<Bean> completionService=new ExecutorCompletionService<Bean>(pullThreadPool);

        for(int i=0;i<10;i++){
            SubCallable subCallable=new SubCallable("task_"+i);
            completionService.submit(subCallable);
        }
        try {
            for (int i = 0; i < 10; i++) {
                Future<Bean> future= completionService.take();
                if(future!=null){

                    System.out.println("=================end=======================");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        return new Bean();
    }

}
