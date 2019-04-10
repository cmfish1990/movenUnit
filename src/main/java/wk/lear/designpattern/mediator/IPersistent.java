/*
 * cf
 * FileName: IPersistent.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.mediator;
//同事（接口）
public interface IPersistent {
	void getData(Object data);
	void getData(Object data, Midiator midiator);
	void saveData();
}