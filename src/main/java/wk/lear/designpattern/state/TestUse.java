/*
 * cf
 * FileName: TestUse.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.state;
public class TestUse {
	public static void main(String args[]){
		String smallData = "小数据";
		String middleData = "介于小数据和大数据之间的数据";
		String bifgData = "这里就假定这是一个很大很大很大的数据";
		SaveDataController saveDataController = new SaveDataController();
		saveDataController.save(smallData);
		saveDataController.save(middleData);
		saveDataController.save(bifgData);
	}
}