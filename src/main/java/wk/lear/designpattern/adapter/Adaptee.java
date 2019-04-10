/*
 * cf
 * FileName: Adaptee.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.adapter;
//被适配者
class Adaptee{
	void playMp3(Object src){
		System.out.println("播放MP3：" + src);
	}
}