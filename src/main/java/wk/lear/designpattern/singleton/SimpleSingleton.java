/*
 * cf
 * FileName: SimpleSingleton.java
 * Author:   BM
 * Date:     2019-03-11 17:01:41
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:41> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.singleton;
/**
 * 简单的单例模式，不能用于多线程
 *
 *
 */
public class SimpleSingleton {
	private static SimpleSingleton instance;
	private SimpleSingleton(){}
	public static SimpleSingleton getIntance(){
		if(instance == null)
			instance = new SimpleSingleton();
		return instance;
	}
}
