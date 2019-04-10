/*
 * cf
 * FileName: DateBuilder1.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.builder;
//具体生成器
public class DateBuilder1 implements IDateBuilder{
	private MyDate myDate;
	public DateBuilder1(MyDate myDate){
		this.myDate = myDate;
	}
	@Override
	public IDateBuilder buildDate(int y, int m, int d) {
		myDate.date = y+"-"+m+"-"+d;
		return this;
	}
	@Override
	public String date() {
		return myDate.date;
	}
}
