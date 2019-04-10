/*
 * cf
 * FileName: CardMember.java
 * Author:   BM
 * Date:     2019-05-26 17:45:47
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-26 17:45:47> <version> <desc> <source>
 *
 */

package wk.lear.exdesignpattern.strategy;

/**
 * Created by bm on 18-5-26.
 */
public class CardMemberStrategy  implements BaseStrategy{

    @Override
    public void pay(User user) {
        int paycout=user.getPayCount();
        System.out.println("card member:"+paycout);
        user.setScore(user.getScore()+1000);
    }
}
