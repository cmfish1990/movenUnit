/*
 * cf
 * FileName: SubCallable.java
 * Author:   BM
 * Date:     2019-01-17 23:46:16
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-01-17 23:46:16> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.executor;

import java.util.concurrent.Callable;

/**
 * Created by bm on 18-1-17.
 */
public class SubCallable implements Callable<Bean> {

    private String taskCount;

    @Override
    public Bean call() throws Exception {
        Bean bean=new Bean();
        for(int i=0;i<1;i++){
             bean.setUserAddress(Thread.currentThread().getName()+":"+i);
             bean.setUserAge(Thread.currentThread().getName()+":"+i);
             bean.setUserAddress(Thread.currentThread().getName()+":"+i);
             bean.setTaskCount(taskCount);
         //    System.out.println(JSONObject.toJSONString(wk.cityhome.dowork.bean));
        }
        return bean;
    }
    public SubCallable(String taskCount){
        this.taskCount=taskCount;
    }

    public String getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(String taskCount) {
        this.taskCount = taskCount;
    }
}
