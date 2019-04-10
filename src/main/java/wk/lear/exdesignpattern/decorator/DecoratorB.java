/*
 * cf
 * FileName: DecoratorB.java
 * Author:   BM
 * Date:     2019-05-27 00:37:44
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-27 00:37:44> <version> <desc> <source>
 *
 */

package wk.lear.exdesignpattern.decorator;

/**
 * Created by bm on 18-5-27.
 */
public class DecoratorB extends Decorator {

    Component component;

    public DecoratorB(Component decorator){
        this.component=decorator;
    }

    @Override
    public String getDescription() {
        return component.getDescription()+" :加珍珠";
    }

    @Override
    public Double getCost() {
        return component.getCost()+2;
    }
}
