/*
 * cf
 * FileName: Dispatch.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.visitor;
//演示java的静态分派和动态分派
//结果会输出：Collection
//所以重载的分派是根据静态类型进行的
public class Dispatch {
	void print(FatherClass c){
		System.out.print("父类");
	}
	void print(ChildClass c){
		System.out.print("子类");
	}
	public static void main(String args[]){
		FatherClass child = new ChildClass();
		new Dispatch().print(child);
		child.print();
	}
}

class FatherClass{
	void print(){
		System.out.println("父类");
	}
}

class ChildClass extends FatherClass{
	void print(){
		System.out.print("子类");
	}
}