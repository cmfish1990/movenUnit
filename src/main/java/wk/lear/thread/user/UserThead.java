/*
 * Copyright (C),2015-2019.
 * FileName: UserThead.java
 * Author:   BM
 * Date:     2019-12-16 23:37:30
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-12-16 23:37:30> <version> <desc> <source>
 *
 */

package wk.lear.thread.user;


public class UserThead extends Thread {

    private User user;

    public UserThead(User user){
        super();
        this.user=user;
    }

    @Override
    public void run(){
        try {
            user.setName("bb");
            Thread.sleep(1000);
            user.setPassWord("bb");
        }catch (InterruptedException e){

        }
    }
}
