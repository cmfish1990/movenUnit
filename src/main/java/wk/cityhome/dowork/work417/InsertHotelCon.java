

package wk.cityhome.dowork.work417;

import java.util.UUID;

public class InsertHotelCon {

    public static String getOrderIdByUUId() {
        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }
    public static void main(String[] args) {
        System.out.println(getOrderIdByUUId());

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);

        String s = UUID.randomUUID().toString();
        //去掉“-”符号
        String news= s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
        System.out.println(news);
    }
}
