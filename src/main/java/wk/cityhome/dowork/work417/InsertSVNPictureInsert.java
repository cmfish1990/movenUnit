

package wk.cityhome.dowork.work417;

import wk.cityhome.dowork.bean.RoomModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class InsertSVNPictureInsert {
    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args) throws Exception {

        String sql2="select *from hotelpicture where roommodeltype is null or roommodeltype = 'NUll'";
        DBHelper  db2 = new DBHelper(sql2);
        ResultSet  ret2 = db2.pst.executeQuery();
        Map<String,String >myMap=new HashMap<String, String>();

        while (ret2.next()){

           String key=ret2.getString("图片URL");
            myMap.put(key,"noreplace");

        }

        String sql3="select *from roommodels ";
        DBHelper  db3 = new DBHelper(sql3);
        ResultSet  ret3 = db3.pst.executeQuery();
        Map<String,String >hotelMap=new HashMap<String, String>();

        while (ret3.next()){
            String hotlepic=ret3.getString("酒店编号");
            String roommodelType=ret3.getString("房型种类编号");
            String id=ret3.getString("Id");
            String key=hotlepic+roommodelType;
            hotelMap.put(key,id);

        }

        String sql5="select * from hotelbiref";
        DBHelper  db5 = new DBHelper(sql5);
        ResultSet  ret5 = db5.pst.executeQuery();
        Map<String,String >myMapBiref=new HashMap<String, String>();

        while (ret5.next()){

            String key=ret5.getString("酒店编号");
            String value=ret5.getString("ID");
            myMapBiref.put(key,value);

        }



        sql = "select *from roommodelpicture1 ";//SQL语句
        db1 = new DBHelper(sql);//创建DBHelper对象


        File file = new File("E:\\ newpicture.txt");
        OutputStream out = new FileOutputStream(file);
        int count=0;

        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集
            List<RoomModel> roomModelList = new ArrayList<RoomModel>();

            while (ret.next()) {
                String hotelNum = ret.getString("酒店编号");
                String roommodelNum = ret.getString("房型种类编码");
                String huazhuUrl = ret.getString("图片url");
                String picName = ret.getString("图片名称");
                String roommodelName = ret.getString("房型名称");

                String hotelId="H"+myMapBiref.get(hotelNum);
                String roommodelid=hotelMap.get(hotelNum+roommodelNum);
                String newurl="/roommodel/"+hotelId+"/R"+roommodelid;
                String status="EBL";
                String createAt="ADMIN_20190321";
                String uuid=getUUid(huazhuUrl);
                String smallurl=null;

                //
//                String mapvalue=myMap.get(huazhuUrl);
//                if (mapvalue==null){
                    smallurl =newurl+"/"+uuid;
//                }else if("noreplace".equals(mapvalue)){
//
//                    smallurl =newurl+"/"+uuid;
//                    myMap.put(huazhuUrl,smallurl);
//                }
//                else {
//                    smallurl=mapvalue;
//                }


                String insertSql="";
                if (count % 100 == 0) {
                     insertSql="insert into roommodelpicture(roomModelId,pictureName,smallUrl,largeUrl,status,hotelNumber,roomModelTypeNumber,huazhuUrl,createBy,createAt) values";
                    insertSql+=" ("+roommodelid+",'"+picName+"','"+smallurl+"','"+smallurl+"','EBL','"+hotelNum+"','"+roommodelNum+"','"+huazhuUrl+"','"+createAt+"',now())";
                } else if ((count % 100) + 1 == 100) {
                    insertSql+=" ,("+roommodelid+",'"+picName+"','"+smallurl+"','"+smallurl+"','EBL','"+hotelNum+"','"+roommodelNum+"','"+huazhuUrl+"','"+createAt+"',now())";
                    insertSql += ";\r\n";
                } else {
                    insertSql+=" ,("+roommodelid+",'"+picName+"','"+smallurl+"','"+smallurl+"','EBL','"+hotelNum+"','"+roommodelNum+"','"+huazhuUrl+"','"+createAt+"',now())";
                }
                count++;

                // 把内容转换成字节数组
                byte[] data = insertSql.getBytes();
                // 向文件写入内容
                out.write(data);
            }
          System.out.println(count);
            out.close();



            ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getUUid(String huazhuUrl) {

        String s=huazhuUrl;
        String snew[]=s.split("/");
        String newhe=snew[snew.length-1];
        String slv[]= newhe.split("\\.");
        return slv[0];





//        UUID uuid = UUID.randomUUID();
//
//        String s = UUID.randomUUID().toString();
//        //去掉“-”符号
//       // return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
//        return uuid.toString();
    }

}
