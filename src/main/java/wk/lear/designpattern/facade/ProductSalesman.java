/*
 * cf
 * FileName: ProductSalesman.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.facade;
//外观
public enum ProductSalesman {
	instance;
	Stock stock = new Stock();
	FinalPrice finalPrice = new FinalPrice();
	Object buySomething(String product,String addr,String discountCode){
		if(!stock.hasStock(product))
			return "库存不足";
		int price = finalPrice.getFinalPrice(product, addr, discountCode);
		return "订单信息:" + product + "-" + addr + "-"  + discountCode + "-"  + price;
	}
}
