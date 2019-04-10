/*
 * cf
 * FileName: Postage.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.facade;
//计算邮费
public class Postage {
	int getPostage(String addr){
		return Math.abs(addr.hashCode())%20+6;//模拟邮费计算
	}
}
