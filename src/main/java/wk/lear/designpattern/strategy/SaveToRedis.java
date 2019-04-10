/*
 * cf
 * FileName: SaveToRedis.java
 * Author:   BM
 * Date:     2019-03-11 17:01:49
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:49> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.strategy;
//具体策略
public class SaveToRedis implements ISaveData {
	@Override
	public void save(Object data) {
		System.out.println("数据：" + data + " 保存到Redis");
	}
}