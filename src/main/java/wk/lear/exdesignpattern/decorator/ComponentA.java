/*
 * cf
 * FileName: ComponentA.java
 * Author:   BM
 * Date:     2019-05-27 00:31:02
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-27 00:31:02> <version> <desc> <source>
 *
 */

package wk.lear.exdesignpattern.decorator;

/**
 * Created by bm on 18-5-27.
 */
public class ComponentA implements Component {
    @Override
    public String getDescription() {
        return "原味奶茶";
    }

    @Override
    public Double getCost() {
        return 4.0;
    }

    public void toTest(){
        System.out.println("componentA test");
    }

}
