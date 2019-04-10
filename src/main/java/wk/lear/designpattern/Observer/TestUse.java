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

package wk.lear.designpattern.Observer;


public class TestUse {
	public static void main(String args[]){
		//创建主题
		WeatherService service = WeatherService.instance;
		//添加观察者
		service.addClient(new ClientAndroidServer());
		service.addClient(new ClientIphoneServer());
		//更新主题
		service.updateWeather(new WeatherInfo(System.currentTimeMillis(), "多云"));
		service.updateWeather(new WeatherInfo(System.currentTimeMillis()+1000*60*60*24, "多云转晴"));
		service.updateWeather(new WeatherInfo(System.currentTimeMillis()+1000*60*60*24*2, "晴"));
	}
}