/*
 * Copyright (C),2015-2019.
 * FileName: ThreadA.java
 * Author:   BM
 * Date:     2019-12-16 23:43:08
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-12-16 23:43:08> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.thread.enub;

/**
 * Created by bm on 17-12-16.
 */
public class ThreadA extends  Thread {
    private EnumObject obj;

    public  ThreadA(EnumObject obj){
        this.obj=obj;
    }
    public  void run(){
        obj.printStr("a");
    }
}
