

package wk.cityhome.dowork.work417;

import java.io.*;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class ReplacePicurl {


    public static void main(String args[]) throws Exception{

        String sql2="select *from roommodelpicture2  ";
        DBHelper  db2 = new DBHelper(sql2);
        ResultSet ret2 = db2.pst.executeQuery();
        Map<String,String > myMap2=new HashMap<String, String>();


        while (ret2.next()){

            String paths=ret2.getString("smallUrl");
            String path[]=paths.split("/");
            String hotelpath=path[2];
            String roompath=path[3];
            String picName=path[4];
            myMap2.put(path[3]+"/"+path[4],path[2]);
        }

        ret2.close();
        db2.close();//关闭连接


        String sql="select * from roommodelpicture ";
        DBHelper  db = new DBHelper(sql);
        ResultSet ret = db.pst.executeQuery();

        File file = new File("E:\\ updatepicUrl.txt");
        OutputStream out = new FileOutputStream(file);
        int count=0;
        while (ret.next()){
            String paths=ret.getString("smallUrl");
            int id=ret.getInt("pid");
            String path[]=paths.split("/");
            String hotelNumber =myMap2.get(path[3] + "/" + path[4]);
            String newpath=paths.replace("Hnull", hotelNumber);
            String updateSql="update roommodelpicture set smallUrl ='"+newpath+"',largeUrl='"+newpath+"'where pid ="+id;
            updateSql += ";\r\n";
            count++;
            // 把内容转换成字节数组
            byte[] data = updateSql.getBytes();
            // 向文件写入内容
            out.write(data);
        }
       System.out.println(count);
        out.close();
        ret.close();
        db.close();//关闭连接


    }

}
