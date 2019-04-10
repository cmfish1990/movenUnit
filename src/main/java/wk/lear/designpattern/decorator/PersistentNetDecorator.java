/*
 * cf
 * FileName: PersistentNetDecorator.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.decorator;
//装饰--存入网络其他地方
public class PersistentNetDecorator extends PersistentDecorator {
	public PersistentNetDecorator(IPersistentUtil iPersistentUtil){
		super(iPersistentUtil);
	}
	@Override
	public void persistentMsg(String msg) {
		iPersistentUtil.persistentMsg(msg);
		persistentToNet(msg);
	}
	private void persistentToNet(String msg){
		System.out.println(msg + " 存入网络的其他地方");
	}
}