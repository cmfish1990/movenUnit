/*
 * cf
 * FileName: TestUse.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.adapter;
public class TestUse {
	public static void main(String args[]){
		Adaptee adaptee = new Adaptee();
		adaptee.playMp3("mp3");
		Target target = new ClassAdapter();
		target.playFlac("flac");
		target = new ObjectAdapter();
		target.playFlac("flac");
	}
}