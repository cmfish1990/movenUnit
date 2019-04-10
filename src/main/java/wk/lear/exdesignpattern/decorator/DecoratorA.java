/*
 * cf
 * FileName: DecoratorA.java
 * Author:   BM
 * Date:     2019-05-27 00:35:33
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-27 00:35:33> <version> <desc> <source>
 *
 */

package wk.lear.exdesignpattern.decorator;

/**
 * Created by bm on 18-5-27.
 */
public class DecoratorA extends  Decorator {

    Component component;

    DecoratorA(Component component){
        this.component=component;
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
