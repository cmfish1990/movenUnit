/*
 * cf
 * FileName: TargetObject.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.proxy;
//具体对象
public class TargetObject implements AbstractObject {
	@Override
	public void method1() {
		System.out.println("具体对象的方法1");
	}
	@Override
	public int method2() {
		System.out.println("具体对象的方法2");
		return 0;
	}
	@Override
	public void method3() {
		System.out.println("具体对象的方法3");
	}
}
