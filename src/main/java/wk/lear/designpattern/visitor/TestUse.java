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

package wk.lear.designpattern.visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class TestUse {
	public static void main(String args[]){
		Visitor appOwner = new APPOwner();
		ArrayList<User> users = new ArrayList<User>();
		users.add(new UserOrdinary("普通用户短反馈"));
		users.add(new UserOrdinary("这是一个普通用户的比较长的反馈"));
		users.add(new UserVIP("VIP用户的短反馈"));
		users.add(new UserVIP("VIP用户的比较长的反馈反馈"));
		Iterator<User> iterator =  users.iterator();
		while(iterator.hasNext()){
			iterator.next().accept(appOwner);
		}
	}
}