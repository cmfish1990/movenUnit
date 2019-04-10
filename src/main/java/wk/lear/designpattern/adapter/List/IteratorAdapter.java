/*
 * cf
 * FileName: IteratorAdapter.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.adapter.List;
import java.util.Enumeration;
import java.util.Iterator;

//适配器，目标就是Iterator，被适配者是Enumeration
public class IteratorAdapter implements Iterator<String> {
	Enumeration<String> myEnum;
	public IteratorAdapter(Enumeration<String> myEnum){
		this.myEnum = myEnum;
	}
	@Override
	public boolean hasNext() {
		return myEnum.hasMoreElements();
	}
	@Override
	public String next() {
		return myEnum.nextElement();
	}

	@Override
	public void remove() {

	}
}