/*
 * cf
 * FileName: MultiDispatch.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.visitor;

public class MultiDispatch {
	public static void main(String args[]){
		Father child = new Child();
		child.print();
		new Child().print(new Vistor());
	}
}

class Father{
	void print(){
		System.out.println("父类");
	}
}

class Child extends Father{
	void print(){
		System.out.print("子类");
	}
	void print(Vistor c){
		c.print(this);
	}
}

class Vistor {
    public void print(Child child){  
    	child.print();
    }
}