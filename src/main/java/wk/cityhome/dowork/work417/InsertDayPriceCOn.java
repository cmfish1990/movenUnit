

package wk.cityhome.dowork.work417;

import wk.cityhome.dowork.bean.BasePriceBean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class InsertDayPriceCOn {


    public static void main(String args[]) throws Exception{

        String sql1="select * FROM "
               + "(select r.pid roommodeId ,rs.hotelnumber hotelNumber ,rs.roommodeltype roommodelType,rs.roommodelname roommodelName from roommodel r,units u,roommodels rs"
                + "         where r.unitId=u.pid  and u.hotelNumber =rs.hotelnumber  and r.roomModelNumber =rs.roommodelType) a ,"
                + "  (select p.hotelNumber  hotelNumber,p.roomType roomType,p.price,c.count from z_price p,z_count c where  p.hotelNumber =c.hotelNum and p.roomType =c.roomType )b"
                + " where a.hotelNumber=b.hotelNumber and a.roommodelType=b.roomType";


        DBHelper  db1 = new DBHelper(sql1);
        ResultSet ret1 = db1.pst.executeQuery();
        Map<String,BasePriceBean > hotemNumberTypeMap=new HashMap<String, BasePriceBean>();

        while (ret1.next()) {
            String roommodeId = ret1.getString("roommodeId");
            String hotelNumber = ret1.getString("hotelNumber");
            String roommodelType = ret1.getString("roommodelType");
            String price=ret1.getString("price");
            String count= ret1.getString("count");

            BasePriceBean bean=new BasePriceBean();
            bean.setRoommodelId(roommodeId);
            bean.setHotelNumber(hotelNumber);
            bean.setRoommodelType(roommodelType);
            bean.setPrice(price);
            bean.setCount(count);
            hotemNumberTypeMap.put(hotelNumber+ roommodelType, bean);

        }


        ret1.close();
        db1.close();//关闭连接

        String sql2="select hcount.hotelNum hotelNum,hcount.roomType roomType,hcount.startTime time,hcount.sellcount baseCount,hprice.basePrice basePrice from hotelinventory hcount,hotelratecodedetail hprice"+
       "  where hcount.hotelNum=hprice.hotelNum and hcount.roomType =hprice.roomType and hcount.startTime =hprice.startTime  ";

        DBHelper  db2 = new DBHelper(sql2);
        ResultSet ret2 = db2.pst.executeQuery();
        File file = new File("E:\\ inserDay.txt");
        OutputStream out = new FileOutputStream(file);
        int count=0;
        Map<String,String >roomModelIdMap=new HashMap<String, String>();
        while (ret2.next()) {

            String hotelnumber = ret2.getString("hotelNum");
            String roomType = ret2.getString("roomType");
            String sellcount = ret2.getString("baseCount");
            String price=ret2.getString("basePrice");
            String data=ret2.getString("time").split(" ")[0];

            BasePriceBean bean=hotemNumberTypeMap.get(hotelnumber + roomType);
            if(bean!=null) {
                String roommodelId = bean.getRoommodelId();

                if (bean.getPrice().equals(price) && bean.getCount().equals(sellcount)) {

                } else {
                    if ("yes".equals(roomModelIdMap.get(roommodelId + data))) {
                    }
                    else {
                        if (sellcount == null) {
                            sellcount = 0 + "";
                        }
                        if (price == null) {
                            price = 0 + "";
                        }
                        int newprice;
                        try {
                             newprice = Integer.parseInt(price) * 100;
                        }
                        catch (Exception e){
                            newprice=0;
                        }
                        int newcount;
                        try {
                            newcount = Integer.parseInt(sellcount);
                        }
                        catch (Exception e){
                            newcount=0;
                        }

                        roomModelIdMap.put(roommodelId + data, "yes");
                        String insertSql="";
                        if (count % 10000 == 0) {
                            insertSql = "insert into roommodeldailyprice(roomModelId,periodDate,count,totalCount,price,status,createBy,createAt) values";
                            insertSql += " (" + roommodelId + ",'" + data + "'," + newcount + "," + newcount + "," + newprice + ",'EBL','ADMIN_20190331',now())";
                        } else if ((count % 10000) + 1 == 10000) {
                            insertSql += ", (" + roommodelId + ",'" + data + "'," + newcount + "," + newcount + "," + newprice + ",'EBL','ADMIN_20190331',now())";
                            insertSql += ";\r\n";
                        } else {
                            insertSql += ", (" + roommodelId + ",'" + data + "'," + newcount + "," + newcount + "," + newprice + ",'EBL','ADMIN_20190331',now())";
                        }
                        byte[] mydata = insertSql.getBytes();
                        // 向文件写入内容
                        out.write(mydata);
                        count++;
                    }
//换成字节数组

                }
            }

        }
        System.out.println(count);
        out.close();
        ret2.close();
        db2.close();//关闭连接


    }



}
