/*
 * cf
 * FileName: PersistentFile.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.mediator;
//具体同事
public class PersistentFile implements IPersistent{
	private Object data;
	@Override
	public void getData(Object data, Midiator midiator) {
		getData(data);
		midiator.notifyOther(this, data);
	}
	@Override
	public void saveData() {
		System.out.println(data + " 已保存到文件");
	}
	@Override
	public void getData(Object data) {
		this.data = data;
		saveData();
	}
}
