/*
 * cf
 * FileName: MyIterator.java
 * Author:   BM
 * Date:     2019-03-11 17:01:49
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:49> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.iterator;

//只是需要遍历一堆数据，那么只需要2个方法就可以了
public interface MyIterator<T> {
	boolean hasNext();	//是否还有下一个元素
	T next();			//得到下一个元素
	T remove();
}