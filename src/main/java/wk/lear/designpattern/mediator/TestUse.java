/*
 * cf
 * FileName: TestUse.java
 * Author:   BM
 * Date:     2019-03-11 17:01:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:50> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.mediator;
public class TestUse {
	public static void main(String args[]){
		Object data = "数据";
		PersistentDB persistentDB = new PersistentDB();
		PersistentFile persistentFile = new PersistentFile();
		Midiator midiator = new Midiator();
		midiator.setPersistentDB(persistentDB).setPersistentFile(persistentFile);
		persistentDB.getData(data, midiator);
		persistentFile.getData(data, midiator);
	}
}