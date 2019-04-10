/*
 * cf
 * FileName: IteratorCollection.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.abstractfactory.iterator;
import java.util.Collection;
import java.util.Iterator;

//具体产品，Collection迭代器(用到了代理模式)
public class IteratorCollection<T> implements IIterator<T>{
	Iterator<T> iterator;
	public IteratorCollection(Collection<T> c){
		iterator = c.iterator();
	}
	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}
	@Override
	public T next() {
		return iterator.next();
	}
}
