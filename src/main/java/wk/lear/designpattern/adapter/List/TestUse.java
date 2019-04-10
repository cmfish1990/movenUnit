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

package wk.lear.designpattern.adapter.List;

import java.util.Iterator;

public class TestUse {
	public static void main(String args[]){
		BookAdapter books = new BookAdapter();
		books.add("think in java");
		books.add("c++ primer");
		books.add("伊索寓言");
		Iterator<String> iterator = books.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}