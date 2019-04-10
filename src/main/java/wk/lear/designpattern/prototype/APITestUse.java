/*
 * cf
 * FileName: APITestUse.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.prototype;
//使用 java 自带的支持
public class APITestUse {
	public static void main(String args[]) throws CloneNotSupportedException{
		MyObject myObject = new MyObject();
		myObject.i = 500;
		MyObject myObjectClone = (MyObject) myObject.clone();
		System.out.println(myObjectClone.i);
	}
}

class MyObject implements Cloneable{
	int i;
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}