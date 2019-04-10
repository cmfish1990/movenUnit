/*
 * cf
 * FileName: TestUse.java
 * Author:   BM
 * Date:     2019-03-11 17:01:49
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:49> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.builder;
public class TestUse {
	public static void main(String args[]){
		MyDate date = new MyDate();
		IDateBuilder builder;
		builder = new DateBuilder1(date).buildDate(2066, 3, 5);
		System.out.println(builder.date());
		builder = new DateBuilder2(date).buildDate(2066, 3, 5);
		System.out.println(builder.date());
	}
}