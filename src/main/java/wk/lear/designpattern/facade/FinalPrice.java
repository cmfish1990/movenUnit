/*
 * cf
 * FileName: FinalPrice.java
 * Author:   BM
 * Date:     2019-03-11 17:01:40
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:40> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.facade;
//计费子系统
public class FinalPrice {
	ProductPrice productPrice;
	Postage postage;
	Discount discount;
	public FinalPrice(){
		productPrice = new ProductPrice();
		postage = new Postage();
		discount = new Discount();
	}
	int getFinalPrice(String product,String addr,String discountCode){
		return productPrice.getPrice(product)+postage.getPostage(addr)-discount.getDiscount(discountCode);
	}
}
