/*
 * cf
 * FileName: Book.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.adapter.List;

import java.util.Enumeration;
import java.util.Vector;

//被适配者
public class Book{
	private Vector<String> books;
	public Book(){
		books = new Vector<String>();
	}
	public void add(String book){
		books.add(book);
	}
	public Enumeration<String> getEnum(){
		return books.elements();
	}
}