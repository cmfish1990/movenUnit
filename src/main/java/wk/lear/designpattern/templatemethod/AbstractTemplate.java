/*
 * cf
 * FileName: AbstractTemplate.java
 * Author:   BM
 * Date:     2019-03-11 17:01:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:48> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.templatemethod;
//抽象模板
public abstract class AbstractTemplate {
	Object data;
	//这个就是模板方法
	void dealData(){
		getData();
		calcData();
		printData();
	}
	//下面是普通方法，可能已经实现，也可能需要子类实现
	abstract void getData();
	abstract void calcData();
	void printData(){
		System.out.println(data);
	}
}