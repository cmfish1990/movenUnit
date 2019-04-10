/*
 * cf
 * FileName: IIteratorFactory.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.abstractfactory.iterator;
import java.util.Collection;
import java.util.Map;

//抽象工厂
public interface IIteratorFactory<T> {
	IIterator<T> iteratorMap(Map<T, Object> m);
	IIterator<T> iteratorCollection(Collection<T> c);
}