/*
 * cf
 * FileName: ClientIphoneServer.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.Observer;

public class ClientIphoneServer implements Client {
	private static String name = "苹果服务";
	private WeatherInfo info;
	@Override
	public void getWeather(WeatherInfo info) {
		this.info = info;
		dealMsg();
	}
	private void dealMsg(){
		System.out.println(name + "收到最新天气：time="+info.getTime()+"msg="+info.getWeather()+"。马上开始推送消息...");
	}
}
