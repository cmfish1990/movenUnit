/*
 * cf
 * FileName: Visitor.java
 * Author:   BM
 * Date:     2019-03-11 17:01:47
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:47> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.visitor;
//抽象访问者
public interface Visitor {
	void visit(UserVIP user);
	void visit(UserOrdinary user);
}