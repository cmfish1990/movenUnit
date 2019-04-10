/*
 * cf
 * FileName: TestUse.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.proxy;
public class TestUse {
	public static void main(String args[]){
		AbstractObject obj = new ProxyObject();
        obj.method1();
        obj.method2();
        obj.method3();
	}
}