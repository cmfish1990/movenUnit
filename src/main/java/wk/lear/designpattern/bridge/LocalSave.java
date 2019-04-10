/*
 * cf
 * FileName: LocalSave.java
 * Author:   BM
 * Date:     2019-03-11 17:01:49
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:49> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.bridge;
//细化抽象
public class LocalSave extends AbstractSave{
	public LocalSave(ISaveData saveData) {
		super(saveData);
	}
	@Override
	public void save(Object data) {
		System.out.print("本地存储：");
		saveData.save(data);
	}
}