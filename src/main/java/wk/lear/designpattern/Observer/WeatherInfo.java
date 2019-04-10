/*
 * cf
 * FileName: WeatherInfo.java
 * Author:   BM
 * Date:     2019-03-11 17:01:49
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:49> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.Observer;
//天气的消息实体
public class WeatherInfo {
	private long time;
	private String weather;
	public WeatherInfo(long time,String weather){
		this.time = time;
		this.weather = weather;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	@Override
	public boolean equals(Object obj) {
		WeatherInfo info = (WeatherInfo) obj;
		return info.time==this.time&&info.weather.equals(this.weather);
	}
}
