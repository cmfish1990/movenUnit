/*
 * cf
 * FileName: Context.java
 * Author:   BM
 * Date:     2019-05-26 17:43:42
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-26 17:43:42> <version> <desc> <source>
 *
 */

package wk.lear.exdesignpattern.strategy;

/**
 * Created by bm on 18-5-26.
 */
public class Context {

    public void pay(User user){
        BaseStrategy strategy;
        if(user.getScore()==0){
            strategy=new CardMemberStrategy();
        }else  if(user.getScore()==1000){
            strategy=new DiamondCardMember();
        }else  if(user.getScore()==2000){
            strategy=new GoldCardMember();
        }else  if(user.getScore()==3000){
            strategy=new PlatinumCardMember();
        }else{
            strategy=new CardMemberStrategy();
        }
        strategy.pay(user);
    }
}
