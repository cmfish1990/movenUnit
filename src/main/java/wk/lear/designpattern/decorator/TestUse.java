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

package wk.lear.designpattern.decorator;

public class TestUse {
	public static void main(String args[]){
		//被装饰者
		final String data = "数据";
		IPersistentUtil iPersistentUtil = new PersistentUtil();
		iPersistentUtil.persistentMsg(data);
		System.out.println("下面装饰数据库持久化：");
		iPersistentUtil = new PersistentDbDecorator(iPersistentUtil);
		iPersistentUtil.persistentMsg(data);
		System.out.println("下面继续装饰网络存储器持久化：");
		iPersistentUtil = new PersistentNetDecorator(iPersistentUtil);
		iPersistentUtil.persistentMsg(data);
	}
}