/*
 * cf
 * FileName: PersistentDB.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.mediator;
//具体同事
public class PersistentDB implements IPersistent{
	private Object data;
	@Override
	public void getData(Object data, Midiator midiator) {
		getData(data);
		midiator.notifyOther(this, data);
	}
	@Override
	public void saveData() {
		System.out.println(data + " 已保存到数据库");
	}
	@Override
	public void getData(Object data) {
		this.data = data;
		saveData();
	}
}
