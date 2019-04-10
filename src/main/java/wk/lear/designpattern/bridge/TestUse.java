/*
 * cf
 * FileName: TestUse.java
 * Author:   BM
 * Date:     2019-03-11 17:01:47
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:47> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.bridge;
public class TestUse {
	public static void main(String args[]){
		Object data = "数据";
		ISaveData saveDataDb = new SaveToDB();
		ISaveData saveDataFile = new SaveToFile();
		AbstractSave save;
		save = new NetSave(saveDataDb);
		save.save(data);
		save = new NetSave(saveDataFile);
		save.save(data);
		save = new LocalSave(saveDataDb);
		save.save(data);
		save = new LocalSave(saveDataFile);
		save.save(data);
	}
}