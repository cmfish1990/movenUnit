/*
 * cf
 * FileName: CouponCodeMake.java
 * Author:   BM
 * Date:     2019-04-03 13:40:00
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-04-03 13:40:00> <version> <desc> <source>
 *
 */

package wk.cityhome.promotion;

import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;


/**
 * 优惠券吗生成
 * 不重复 十位 去除 o i z 全小写字母
 */

public class CouponCodeMake {
    private static final String PASSWORD_CRYPT_KEY = "Jeff_Key";

    public static void main(String[] args) throws Exception{

        for(int i=0;i<1;i++){
            System.out.println(makeCouponCodeTest());
        }
    }


    public  static String makeCouponCodeTest() throws Exception{
        String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m", "n", "p",
                "q", "r", "s", "t", "u", "v", "w", "x", "y"};
        StringBuffer outChars = new StringBuffer();
        for (int j = 0; j < 10; j++) {
            //比较耗时 建议转成ASCII码
            String nanoTimeStr=String.valueOf(System.nanoTime());
            byte[] desReturn=  DescUtil.encrypt(nanoTimeStr.getBytes(), "Jeff_Key".getBytes());
        }
        return outChars.toString();
    }
    public  static String makeCouponCode(){
        String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "m", "n", "p",
                "q", "r", "s", "t", "u", "v", "w", "x", "y"};
        StringBuffer outChars = new StringBuffer();
        for (int j = 0; j < 10; j++) {
            //比较耗时 建议转成ASCII码
            String nanoTimeStr=String.valueOf(System.nanoTime());
            BigInteger b = new BigInteger(DigestUtils.md5Hex(nanoTimeStr), 16);
            BigInteger index = b.mod(new BigInteger("23"));
            outChars.append(chars[index.intValue()]);
        }
        return outChars.toString();
    }


}
