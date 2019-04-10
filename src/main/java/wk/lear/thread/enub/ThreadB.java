/*
 * Copyright (C),2015-2019.
 * FileName: ThreadB.java
 * Author:   BM
 * Date:     2019-12-16 23:44:25
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-12-16 23:44:25> <version> <desc> <source>
 *
 */

package wk.lear.thread.enub;

/**
 * Created by bm on 17-12-16.
 */
public class ThreadB extends  Thread {
    private EnumObject obj;
    public  ThreadB(EnumObject obj){
        this.obj=obj;
    }
    public  void run(){
        super.run();
        obj.printStr("b");
    }
}
