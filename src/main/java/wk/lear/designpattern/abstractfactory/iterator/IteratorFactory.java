/*
 * cf
 * FileName: IteratorFactory.java
 * Author:   BM
 * Date:     2019-03-11 17:01:47
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:47> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.abstractfactory.iterator;
import java.util.Collection;
import java.util.Map;

//具体工厂
public class IteratorFactory<T> implements IIteratorFactory<T>{
	@Override
	public IteratorMap<T> iteratorMap(Map<T,Object> m) {
		return new IteratorMap<T>(m);
	}
	@Override
	public IteratorCollection<T> iteratorCollection(Collection<T> c) {
		return new IteratorCollection<T>(c);
	}
}