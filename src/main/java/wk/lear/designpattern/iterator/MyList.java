/*
 * cf
 * FileName: MyList.java
 * Author:   BM
 * Date:     2019-03-11 17:01:49
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:49> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.iterator;
//集合接口
public interface MyList<T> {
	MyIterator<T> iterator();	//返回一个遍历器
	boolean add(T t);		//添加元素到列表
	T get(int index);		//得到元素
	T remove();				//删除最后一个元素
	boolean remove(T element);	//删除指定元素
	T remove(int index);	//删除指定位置元素
	boolean set(int index, T element);	//修改指定位置值
	int size();
}