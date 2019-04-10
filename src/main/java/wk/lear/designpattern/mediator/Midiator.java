/*
 * cf
 * FileName: Midiator.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.mediator;
//具体中介者
public class Midiator {
	PersistentDB persistentDB;
	PersistentFile persistentFile;
	public Midiator setPersistentDB(PersistentDB persistentDB) {
		this.persistentDB = persistentDB;
		return this;
	}
	public Midiator setPersistentFile(PersistentFile persistentFile) {
		this.persistentFile = persistentFile;
		return this;
	}
	public void notifyOther(IPersistent persistent,Object data){
		if(persistent instanceof PersistentDB)
			persistentFile.getData(data);
		if(persistent instanceof PersistentFile)
			persistentDB.getData(data);
	}
}
