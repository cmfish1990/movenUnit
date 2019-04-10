/*
 * cf
 * FileName: AbstractSave.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.bridge;
//抽象
public abstract class AbstractSave {
	ISaveData saveData;
	public AbstractSave(ISaveData saveData){
		this.saveData = saveData;
	}
	public abstract void save(Object data);
}
