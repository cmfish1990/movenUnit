/*
 * cf
 * FileName: Stock.java
 * Author:   BM
 * Date:     2019-03-11 17:01:47
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-11 17:01:47> <version> <desc> <source>
 *
 */

package wk.lear.designpattern.facade;

import java.util.Random;

//库存子系统
public class Stock {
	boolean hasStock(String product){
		return new Random().nextInt(Math.abs(product.hashCode()))>0;//模拟是否还有库存
	}
}