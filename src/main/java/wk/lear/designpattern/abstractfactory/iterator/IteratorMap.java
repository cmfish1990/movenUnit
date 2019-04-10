/*
 * cf
 * FileName: IteratorMap.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.abstractfactory.iterator;
import java.util.Iterator;
import java.util.Map;

//具体产品，Map迭代器(用到了代理模式)
public class IteratorMap<T> implements IIterator<T>{
	Iterator<Map.Entry<T, Object>> iterator;
	public IteratorMap(Map<T,Object> m){
		iterator = m.entrySet().iterator();
	}
	@Override
	public boolean hasNext() {
		return iterator.hasNext();
	}
	@Override
	public Object next() {
		return iterator.next().getValue();
	}
}