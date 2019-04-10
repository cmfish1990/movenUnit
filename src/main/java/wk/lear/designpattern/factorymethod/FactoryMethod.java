/*
 * cf
 * FileName: FactoryMethod.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.factorymethod;
//工厂方法模式
public class FactoryMethod {
	public static void main(String args[]){
		IFactory bigfactory;
		bigfactory = new SmallFactory();
		bigfactory.produce().run();
		bigfactory = new BigFactory();
		bigfactory.produce().run();
	}
}

//抽象产品
interface MeizuPhone{
	void run();
}

//具体产品*2
class PRO5 implements MeizuPhone{
	@Override
	public void run() {
		System.out.println("我是一台PRO5");
	}
}

class MX5 implements MeizuPhone{
	@Override
	public void run() {
		System.out.println("我是一台MX5");
	}
}

interface IFactory{
	MeizuPhone produce();
}

//工厂*2
class BigFactory implements IFactory{
	@Override
	public MeizuPhone produce() {
		return new PRO5();
	}
}

class SmallFactory implements IFactory{
	@Override
	public MeizuPhone produce() {
		return new MX5();
	}
}