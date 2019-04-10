/*
 * cf
 * FileName: SaveDataController.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.state;
//环境（Context）
public class SaveDataController {
	private ISaveData saveData;
	public void save(String data){
		//为了演示，此处的大的数据其实也是很小的
		if(data.length()<1<<2)
			saveData = SaveSmallData.instance;
		else if(data.length()<1<<4)
			saveData = SaveMiddleData.instance;
		else
			saveData = SaveBigData.instance;
		saveData.save(data);
	}
}
