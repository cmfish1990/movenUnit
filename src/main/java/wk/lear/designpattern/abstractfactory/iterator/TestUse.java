/*
 * cf
 * FileName: TestUse.java
 * Author:   BM
 * Date:     2019-03-11 17:01:49
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:49> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.abstractfactory.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

//测试使用
public class TestUse {
	public static void main(String args[]){
		IIteratorFactory<Integer> factory = new IteratorFactory();
		Collection<Integer> collection = new ArrayList<Integer>();
		Map<Integer, Object> map = new LinkedHashMap();
		for(int i=0;i<10;i++){
			collection.add(i);
			map.put(i, i);
		}
		IIterator<Integer> iteratorCollection = factory.iteratorCollection(collection);
		IIterator<Integer> iteratorMap = factory.iteratorMap(map);
		while(iteratorCollection.hasNext())
			System.out.print(iteratorCollection.next());
		System.out.println();
		while(iteratorMap.hasNext())
			System.out.print(iteratorMap.next());
	}
}