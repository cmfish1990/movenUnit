/*
 * Copyright (C),2015-2019.
 * FileName: EnumObject.java
 * Author:   BM
 * Date:     2019-12-16 23:37:58
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-12-16 23:37:58> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.thread.enub;

/**
 * Created by bm on 17-12-16.
 */
public class EnumObject {
    private  int num=0;
    public void printStr(String userName) {

        try {
            if(userName.equals("a")){
                num =100;
                Thread.sleep(2000);
            }else {
                num=200;
        }
            System.out.println(num +":"+userName);


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
