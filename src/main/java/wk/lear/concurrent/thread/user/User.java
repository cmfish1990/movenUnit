/*
 * Copyright (C),2015-2019.
 * FileName: User.java
 * Author:   BM
 * Date:     2019-12-16 23:37:25
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-12-16 23:37:25> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.thread.user;

public class User {

    private String name="aa";
    private String passWord="bb";

    public User(String name,String passWord){
        this.name=name;
        this.passWord=passWord;
    }
    synchronized public void myPrint(){
        System.out.println("name:"+name+",password:"+passWord);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
