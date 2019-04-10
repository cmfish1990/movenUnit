/*
 * Copyright (C),2015-2019.
 * FileName: DeadThread.java
 * Author:   BM
 * Date:     2019-12-19 22:07:12
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-12-19 22:07:12> <version> <desc> <source>
 *
 */

package wk.lear.thread.deadthread;

/**
 * Created by bm on 17-12-19.
 */
public class DeadThread implements Runnable {
    private String userName;

    public Object lock01=new Object();
    public Object lock02=new Object();


    public void  run(){
       if(userName.equals("a")){
           synchronized (lock01){
               try{
                   System.out.println("userName="+userName);
                   Thread.sleep(1000);

               }catch (InterruptedException e){
                 e.printStackTrace();
               }
               synchronized (lock02){
                   System.out.println("userName="+userName+",lock01--->lock02");
               }
           }
       }
        if(userName.equals("b")){
            synchronized (lock02){
                try{
                    System.out.println("userName="+userName);
                    Thread.sleep(1000);

                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized (lock01){
                    System.out.println("userName="+userName+",lock02--->lock01");
                }
            }
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
