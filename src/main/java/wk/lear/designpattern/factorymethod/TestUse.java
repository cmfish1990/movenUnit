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

package wk.lear.designpattern.factorymethod;
public class TestUse {
	public static void main(String args[]){
		//分别定义两种结构
		List<Integer> array = new ArrayList<Integer>();
		List<Integer> link = new LinkList<Integer>();
		//添加数据
		for(int i = 1;i < 8; i++){
			array.add(i);
			link.add(i);
		}
		//获得迭代器
		Iterator<Integer> ai = array.iterator();
		Iterator<Integer> li = link.iterator();
		//遍历并输出
		while(ai.hasNext())
			System.out.print(ai.next());
		System.out.println();
		while(li.hasNext())
			System.out.print(li.next());
	}
}