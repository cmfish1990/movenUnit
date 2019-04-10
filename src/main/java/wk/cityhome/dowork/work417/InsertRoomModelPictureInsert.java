

package wk.cityhome.dowork.work417;

import wk.cityhome.dowork.bean.RoomModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertRoomModelPictureInsert {
    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args) throws Exception{
        sql = "select *from roommodels ";//SQL语句
        db1 = new DBHelper(sql);//创建DBHelper对象

        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集
            List<RoomModel> roomModelList=new ArrayList<RoomModel>();
            while (ret.next()) {
                String uid = ret.getString("酒店编号");
                String ufname = ret.getString("房型名称");
                String ulname = ret.getString("房型种类编号");
                 System.out.println(ret.getString("房型名称"));

                String sql2="select *from hotelpicture where hotelNum ='"+uid+"' and ( roommodeltype is null or roommodeltype = 'NUll')";
                DBHelper  db2 = new DBHelper(sql2);
                ResultSet  ret2 = db2.pst.executeQuery();

                while (ret2.next()){
                    RoomModel model=new RoomModel();
                    model.setHotleNum(uid);
                    model.setRoomModelName(ufname);
                    model.setRoomModelType(ulname);
                    model.setPictureName(ret2.getString("图片名称"));
                    model.setPicUrl(ret2.getString("图片URL"));
                    roomModelList.add(model);
                }

                ret2.close();
                db2.close();//关闭连接
                String sql3="select *from hotelpicture where hotelNum ='"+uid+"' and roommodeltype  ='"+ulname+"'";
                DBHelper  db3 = new DBHelper(sql3);
                ResultSet  ret3 = db3.pst.executeQuery();
                while (ret3.next()){
                    RoomModel model=new RoomModel();
                    model.setHotleNum(uid);
                    model.setRoomModelName(ufname);
                    model.setRoomModelType(ulname);
                    model.setPictureName(ret3.getString("图片名称"));
                    model.setPicUrl(ret3.getString("图片URL"));
                    roomModelList.add(model);
                }
                ret3.close();
                db3.close();//关闭连接
            }

            Map<String,String> myMap=new HashMap<String, String>();
            String sql4="select * from hotels ";
            DBHelper  db4 = new DBHelper(sql4);
            ResultSet  ret4= db4.pst.executeQuery();

            while (ret4.next()){
                String    hotelname=ret4.getString("酒店名称");
                String   hotelNum=ret4.getString("hotelNum");
                myMap.put(hotelNum,hotelname);


            }
            ret4.close();
            db4.close();//关闭连接

            File file = new File("E:\\ roommodelpicture.txt");
            OutputStream out = new FileOutputStream(file);
            int count=0;
            for(int i=0;i<roomModelList.size();i++)
            {
               RoomModel roomModel=roomModelList.get(i);
                String hoteName=myMap.get(roomModel.getHotleNum());
                String message="";

                if(count%100==0){
                    message="insert into roommodelpicture values('"+hoteName+"','"+roomModel.getRoomModelName()+"','"+roomModel.getHotleNum()+"','"+roomModel.getRoomModelType()+"','"+roomModel.getPictureName()+"','"+roomModel.getPicUrl()+"')";
                } else if((count%100)+1==100){
                    message+= ",('"+hoteName+"','"+roomModel.getRoomModelName()+"','"+roomModel.getHotleNum()+"','"+roomModel.getRoomModelType()+"','"+roomModel.getPictureName()+"','"+roomModel.getPicUrl()+"')";
                    message+= ";\r\n";
                  }
                else{
                message+= ",('"+hoteName+"','"+roomModel.getRoomModelName()+"','"+roomModel.getHotleNum()+"','"+roomModel.getRoomModelType()+"','"+roomModel.getPictureName()+"','"+roomModel.getPicUrl()+"')";
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
