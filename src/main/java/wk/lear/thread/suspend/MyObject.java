/*
 * Copyright (C),2015-2019.
 * FileName: MyObject.java
 * Author:   BM
 * Date:     2019-12-16 22:42:38
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-12-16 22:42:38> <version> <desc> <source>
 *
 */

package wk.lear.thread.suspend;

/**
 * Created by bm on 17-12-16.
 */
public class MyObject {
    private  String userName ="a";
    private String passWord="a";
    public void setValue(String userName,String passWord){
        this.userName=userName;
        if(Thread.currentThread().getName().equals("a"))
        Thread.currentThread().suspend();
        this.passWord=passWord;
    }
    public void printStr(){
        System.out.println("name:"+this.userName+",word:"+this.passWord);
    }
}
