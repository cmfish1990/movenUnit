/*
 * cf
 * FileName: List.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.factorymethod;

//便于介绍，不做多的操作
public interface List<T> {
	Iterator<T> iterator();	//返回一个遍历器
	boolean add(T t);		//添加元素到列表
}
