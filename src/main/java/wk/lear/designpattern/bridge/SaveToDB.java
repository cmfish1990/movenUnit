/*
 * cf
 * FileName: SaveToDB.java
 * Author:   BM
 * Date:     2019-03-11 17:01:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:48> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.bridge;
//具体实现
public class SaveToDB implements ISaveData{
	@Override
	public void save(Object data) {
		System.out.println(data + " 存储到数据库");
	}
}
