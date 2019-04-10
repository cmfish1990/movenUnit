

package wk.cityhome.dowork.work417;

import wk.cityhome.dowork.bean.BedBean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomModeBedCon {
    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args) throws Exception {




        sql = "select * from roommodels ";//SQL语句
        db1 = new DBHelper(sql);//创建DBHelper对象

        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集
            List<BedBean> list = new ArrayList<BedBean>();

            Map<String, String> myMap = new HashMap<String, String>();
            String sql4 = "select * from hotels ";
            DBHelper db4 = new DBHelper(sql4);
            ResultSet ret4 = db4.pst.executeQuery();

            while (ret4.next()) {
                String hotelname = ret4.getString("酒店名称");
                String hotelNum = ret4.getString("hotelNum");
                myMap.put(hotelNum, hotelname);
            }
            ret4.close();
            db4.close();//关闭连接
            while (ret.next()) {
                String hotelNum = ret.getString("酒店编号");
                String roommodelName= ret.getString("房型名称");
                String roommodelType= ret.getString("房型种类编号");
                String bedname = ret.getString("床型名称");
                String bedwidth = ret.getString("床宽");


                String beds[]=bedwidth.split("/");

                for(int i=0;i<beds.length;i++){
                    BedBean bed=new BedBean();
                    bed.setHotelName(myMap.get(hotelNum));
                    bed.setHotelNum(hotelNum);
                    bed.setRoommodelName(roommodelName);
                    bed.setRoommodelType(roommodelType);

                   if(beds[i].indexOf("张")>=0)
                   {
                      String s=beds[i];
                       String sun=s.substring(0,4);
                       String count=s.substring(5, 6);
                       bed.setWidth(sun);
                       bed.setCount(count);
                       if(count.indexOf("张")>=0){
                           bed.setWidth(s.substring(0,3));
                           bed.setCount(s.substring(4,5));
                       }

                   }else{
                       bed.setWidth(beds[i]);
                       bed.setCount(1+"");
                   }
                    if(bed.getWidth().indexOf("1.2")>=0){
                       bed.setBedName("单人床");
                    }else if(bed.getWidth().indexOf("1.5")>=0){
                        bed.setBedName("双人床");
                    }else{
                        bed.setBedName("大床");
                    }
                    list.add(bed);
                }



            }
            File file = new File("E:\\ bed.txt");
            OutputStream out = new FileOutputStream(file);
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                BedBean bed = list.get(i);

                String message = "";

                if (count % 50 == 0) {
                    message = "insert into roommodelbed values('" + bed.getHotelName() + "','" + bed.getRoommodelName() + "','" + bed.getHotelNum() + "','" + bed.getRoommodelType() + "','" + bed.getBedName() + "','" + bed.getWidth() + "','" + bed.getCount() + "')";
                } else if ((count % 50) + 1 == 50) {
                    message += ",('" + bed.getHotelName() + "','" + bed.getRoommodelName() + "','" + bed.getHotelNum() + "','" + bed.getRoommodelType() + "','" + bed.getBedName() + "','" + bed.getWidth() + "','" + bed.getCount() + "')";
                    message += ";\r\n";
                } else {
                    message += ",('" + bed.getHotelName() + "','" + bed.getRoommodelName() + "','" + bed.getHotelNum() + "','" + bed.getRoommodelType() + "','" + bed.getBedName() + "','" + bed.getWidth() + "','" + bed.getCount() + "')";
                }
                count++;

                // 把内容转换成字节数组
                byte[] data = message.getBytes();
                // 向文件写入内容
                out.write(data);

            }

            out.close();
            System.out.println(count);
            ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
