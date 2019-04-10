/*
 * cf
 * FileName: IWeatherService.java
 * Author:   BM
 * Date:     2019-03-11 17:01:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:50> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.Observer;
//主题
public interface IWeatherService {
	void addClient(Client client);		//添加观察者
	boolean deleteClient(Client client);//删除观察者
	void notifyClients();				//通知
	void updateWeather(WeatherInfo info);//主题内容更新
}
