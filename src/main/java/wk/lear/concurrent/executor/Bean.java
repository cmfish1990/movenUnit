/*
 * cf
 * FileName: Bean.java
 * Author:   BM
 * Date:     2019-01-17 23:47:45
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-01-17 23:47:45> <version> <desc> <source>
 *
 */

package wk.lear.concurrent.executor;

/**
 * Created by bm on 18-1-17.
 */
public class Bean {

    private String userName;
    private String userAge;
    private String userAddress;
    private String taskCount;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(String taskCount) {
        this.taskCount = taskCount;
    }
}
