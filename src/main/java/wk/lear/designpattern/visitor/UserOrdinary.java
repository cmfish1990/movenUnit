/*
 * cf
 * FileName: UserOrdinary.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.visitor;
//普通用户，具体元素
public class UserOrdinary implements User{
	String estimation;
	public UserOrdinary(String estimation){
		this.estimation = estimation;
	}
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	String getEstimation(){
		return estimation;
	}
}
