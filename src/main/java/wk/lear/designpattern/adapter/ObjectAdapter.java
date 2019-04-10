/*
 * cf
 * FileName: ObjectAdapter.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.adapter;
//对象适配器
public class ObjectAdapter implements Target{
	private Adaptee adaptee;
	public ObjectAdapter(){
		super();
		adaptee = new Adaptee();
	}
	@Override
	public void playFlac(Object src) {
		//可能需要对src作处理
		adaptee.playMp3(src);
	}
}