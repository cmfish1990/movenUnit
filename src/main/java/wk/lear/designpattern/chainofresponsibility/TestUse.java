/*
 * cf
 * FileName: TestUse.java
 * Author:   BM
 * Date:     2019-03-11 17:01:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:48> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.chainofresponsibility;
public class TestUse {
	public static void main(String args[]){
		Handler h1,h2,h3;
		h1 = new Handler1();
		h2 = new Handler2();
		h3 = new Handler3();
		h1.setNextHandler(h2);
		h2.setNextHandler(h3);
		System.out.println(h1.handleRequest(-1));
		System.out.println(h1.handleRequest(5));
		System.out.println(h1.handleRequest(9999));
	}
}