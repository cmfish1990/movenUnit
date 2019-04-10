/*
 * Copyright (C),2015-2019.
 * FileName: EnumObjRun.java
 * Author:   BM
 * Date:     2019-12-16 23:44:45
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-12-16 23:44:45> <version> <desc> <source>
 *
 */

package wk.lear.thread.enub;

/**
 * Created by bm on 17-12-16.
 */
public class EnumObjRun {
    public static void main(String[] args) {
        try {
            run02();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 多个对象多个锁
     */
    public  static void run02() throws InterruptedException{
        EnumObject obj1=new EnumObject();
        EnumObject obj2=new EnumObject();
        ThreadA ta = new ThreadA(obj1);
        ta.start();
        Thread.sleep(1000);
        ThreadB tb = new ThreadB(obj2);
        tb.start();

    }

    /**
     * 对象属性不同步问题
     */
    public  static void run01(){
        try {
            EnumObject obj = new EnumObject();
            ThreadA ta = new ThreadA(obj);
            ta.start();
            Thread.sleep(1000);
            ThreadB tb = new ThreadB(obj);
            tb.start();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
