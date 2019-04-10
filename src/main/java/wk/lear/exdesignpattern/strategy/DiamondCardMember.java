/*
 * cf
 * FileName: DiamondCardMember.java
 * Author:   BM
 * Date:     2019-05-26 17:47:24
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-26 17:47:24> <version> <desc> <source>
 *
 */

package wk.lear.exdesignpattern.strategy;

/**
 * Created by bm on 18-5-26.
 */
public class DiamondCardMember implements BaseStrategy {
    @Override
    public void pay(User user) {
        Double paycout=user.getPayCount()*0.9;
        System.out.println("card member:"+paycout);
        user.setScore(user.getScore()+1000);
    }
}
