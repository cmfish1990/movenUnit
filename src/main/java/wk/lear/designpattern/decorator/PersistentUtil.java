/*
 * cf
 * FileName: PersistentUtil.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.decorator;
//具体的被装饰者
public class PersistentUtil implements IPersistentUtil{
	@Override
	public void persistentMsg(String msg) {
		System.out.println(msg + " 存入文件");
	}
}