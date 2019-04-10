/*
 * cf
 * FileName: WeatherFactory.java
 * Author:   BM
 * Date:     2019-03-11 17:01:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:48> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.flyweight;

import java.util.HashMap;

//享元工厂
public class WeatherFactory {
	private HashMap<IWeather, IWeather> weathers;
	public WeatherFactory(){
		weathers = new HashMap<IWeather, IWeather>();
	}
	public IWeather getFlyWeight(String weather,int temperature){
		Weather objectWeather = new Weather(weather, temperature);
		IWeather flyweight = weathers.get(objectWeather);
		if(flyweight == null){
			flyweight = objectWeather;
			weathers.put(objectWeather, flyweight);
		}
		else objectWeather = null;//方便gc回收
		return flyweight;
	}
	public int getFlyweightSize(){
		return weathers.size();
	} 
}