

package wk.cityhome.dowork.work417;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class UpdateBascRoomModelPicture {


    public static void main(String args[]) throws Exception{

        String sql2="select * from  hotelpicture where roommodeltype ='NULL'";
        DBHelper  db2 = new DBHelper(sql2);
        ResultSet ret2 = db2.pst.executeQuery();
        Map<String,String > myMap2=new HashMap<String, String>();
        while (ret2.next()){
            String url=ret2.getString("图片URL");
            String paths[]=url.split("/");
            String x[]=paths[4].split("\\.");
            myMap2.put(x[0],"yes");
        }

        ret2.close();
        db2.close();//关闭连接


        String sql="select * from roommodelpicture  ";
        DBHelper  db = new DBHelper(sql);
        ResultSet ret = db.pst.executeQuery();

        File file = new File("E:\\ baseUrl.txt");
        OutputStream out = new FileOutputStream(file);
        int count=0;
        Map<String,String > updateBascPicture=new HashMap<String, String>();

        while (ret.next()){
            String paths=ret.getString("smallUrl");
            String roommodelId=ret.getString("roomModelId");
            String path[]=paths.split("/");
            String uuid= path[4];
            String hoteltrue=myMap2.get(uuid);
            if("yes".equals(hoteltrue)){

            }else{
               if(updateBascPicture.get(roommodelId)==null){

                   updateBascPicture.put(roommodelId, paths);
                   String updateSql="update roommodel set logoUrl ='"+paths+"' where pid ="+roommodelId+";";
                         updateSql+="\r\n";
                   byte[] data = updateSql.getBytes();
                   // 向文件写入内容
                   out.write(data);
                   count++;

               }
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
