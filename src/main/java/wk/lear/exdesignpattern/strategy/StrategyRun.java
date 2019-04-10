/*
 * cf
 * FileName: StrategyRun.java
 * Author:   BM
 * Date:     2019-05-26 22:34:59
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-26 22:34:59> <version> <desc> <source>
 *
 */

package wk.lear.exdesignpattern.strategy;

/**
 * Created by bm on 18-5-26.
 */
public class StrategyRun {
    public static void main(String[] args) {
        Context context=new Context();
        User user=new User();
        user.setPayCount(1000);
        user.setScore(1000);
        for(int i=0;i<5;i++) {
            context.pay(user);
        }
    }
}
