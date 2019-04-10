/*
 * cf
 * FileName: ProxyObject.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.proxy;
//代理对象
public class ProxyObject implements AbstractObject {
	AbstractObject object = new TargetObject();
	@Override
	public void method1() {
		object.method1();
	}
	@Override
	public int method2() {
		return object.method2();
	}
	@Override
	public void method3() {
		System.out.println("调用目标对象前的操作");
		object.method3();
		System.out.println("调用目标对象后的操作");
	}
}
