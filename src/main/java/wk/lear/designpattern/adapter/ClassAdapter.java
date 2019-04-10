/*
 * cf
 * FileName: ClassAdapter.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.adapter;
//类适配器
public class ClassAdapter extends Adaptee implements Target {
	@Override
	public void playFlac(Object src) {
		//可能需要对src作处理
		playMp3(src);
	}
}