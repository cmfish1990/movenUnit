/*
 * cf
 * FileName: ComponentRun.java
 * Author:   BM
 * Date:     2019-05-27 00:40:22
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-27 00:40:22> <version> <desc> <source>
 *
 */

package wk.lear.exdesignpattern.decorator;

/**
 * Created by bm on 18-5-27.
 */
public class ComponentRun {

    public static void main(String[] args) {

        Component coma=new ComponentA();
        System.out.println(coma.getDescription());
        coma=new DecoratorA(coma);
        coma=new DecoratorA(coma);
        coma=new DecoratorB(coma);
        System.out.println(coma.getDescription());
    }
}
