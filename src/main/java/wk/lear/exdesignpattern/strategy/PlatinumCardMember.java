/*
 * cf
 * FileName: PlatinumCardMember.java
 * Author:   BM
 * Date:     2019-05-26 17:46:45
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-26 17:46:45> <version> <desc> <source>
 *
 */

package wk.lear.exdesignpattern.strategy;

/**
 * Created by bm on 18-5-26.
 */
public class PlatinumCardMember implements BaseStrategy {
    @Override
    public void pay(User user) {
        Double paycout=user.getPayCount()*0.8;
        System.out.println("GoldCardMember:"+paycout);
        user.setScore(user.getScore()+1000);
    }
}
