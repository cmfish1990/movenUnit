

package wk.cityhome.dowork.work417;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class ReplacePicurl2 {


    public static void main(String args[]) throws Exception{

        String sql2=" select r.pid pid ,rs.id rsid from roommodel r,units u,roommodels rs" +
                "  where r.unitId=u.pid  and u.hotelNumber =rs.hotelnumber and r.roomModelName =rs.roommodelname   ";
        DBHelper  db2 = new DBHelper(sql2);
        ResultSet ret2 = db2.pst.executeQuery();
        Map<String,String > myMap2=new HashMap<String, String>();


        while (ret2.next()){

            String pid=ret2.getString("pid");
            String rsid=ret2.getString("rsid");
            myMap2.put(pid,rsid);
        }

        ret2.close();
        db2.close();//关闭连接


        String sql="select * from roommodelpicture ";
        DBHelper  db = new DBHelper(sql);
        ResultSet ret = db.pst.executeQuery();

        File file = new File("E:\\ updatepicUrl2.txt");
        OutputStream out = new FileOutputStream(file);
        int count=0;
        while (ret.next()){
            String paths=ret.getString("smallUrl");
            int roommodelId=ret.getInt("roomModelId");
            int id=ret.getInt("pid");
            String path[]=paths.split("/");
            String oldhuazhuroomId= path[3];
            String huazhuroomId="R"+myMap2.get(roommodelId+"");
            if(!oldhuazhuroomId.equals(huazhuroomId))
            {
                String newpath=paths.replace(oldhuazhuroomId, huazhuroomId);
                String updateSql="update roommodelpicture set smallUrl ='"+newpath+"',largeUrl='"+newpath+"'where pid ="+id;
                updateSql += ";\r\n";
                byte[] data = updateSql.getBytes();
                out.write(data);
                count++;
            }



            // 把内容转换成字节数组

            // 向文件写入内容

        }
       System.out.println(count);
        out.close();
        ret.close();
        db.close();//关闭连接


    }

}
