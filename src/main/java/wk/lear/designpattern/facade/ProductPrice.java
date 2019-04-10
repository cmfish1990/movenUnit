/*
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.facade;
//获取商品价格
public class ProductPrice {
	int getPrice(String product){
		return Math.abs(product.hashCode());//模拟获取商品价格
	}
}
