/*
 * cf
 * FileName: Template.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.templatemethod;
//具体模板
public class Template extends AbstractTemplate {
	@Override
	void getData() {
		data = "data";
	}
	@Override
	void calcData() {
		data = (String)data+data;
	}
}