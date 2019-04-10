/*
 * cf
 * FileName: APPOwner.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.visitor;
//具体访问者
public class APPOwner implements Visitor{
	@Override
	public void visit(UserVIP user) {
		String estimation = user.getEstimation();
		if(estimation.length()>5)
			System.out.println("记录一条有效反馈：" + estimation);
	}
	@Override
	public void visit(UserOrdinary user) {
		String estimation = user.getEstimation();
		if(estimation.length()>10)
			System.out.println("记录一条有效反馈：" + estimation);
	}
}