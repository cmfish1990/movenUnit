

package wk.cityhome.dowork.work417;

import java.io.*;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class MovePictureCon {

    public static void main(String args[]) throws Exception{

        String sql2="select *from roommodelpicture  ";
        DBHelper  db2 = new DBHelper(sql2);
        ResultSet ret2 = db2.pst.executeQuery();
        Map<String,String > myMap=new HashMap<String, String>();
        int count=0;

        while (ret2.next()){

            String paths=ret2.getString("smallUrl");
            String path[]=paths.split("/");
            String hotelpath=path[2];
            String roompath=path[3];
            String picName=path[4];

            String picnamejpg=picName+".jpg";
            String oldpath="f:\\minsujpg\\"+picnamejpg;
            String targetpath="f:\\roommodel\\"+hotelpath+"\\"+roompath;

           String bigpahth="f:\\roommodel\\"+hotelpath;
            judeDirExists(bigpahth);
            judeDirExists(targetpath);
            copyFile(oldpath, targetpath + "\\" + picnamejpg);

           count++;
            System.out.println(count);
        }


        ret2.close();
        db2.close();//关闭连接


    }

    public static void copyFile(String src,String target)
    {
        File srcFile = new File(src);
        File targetFile = new File(target);
        try {
            InputStream in = new FileInputStream(srcFile);
            OutputStream out = new FileOutputStream(targetFile);
            byte[] bytes = new byte[1024];
            int len = -1;
            while((len=in.read(bytes))!=-1)
            {
                out.write(bytes, 0, len);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 判断文件是否存在
    // 判断文件夹是否存在
    public static void judeDirExists(String  path) {
        File file = new File(path);
        if (file.exists()) {

        } else {

            file.mkdir();
        }

    }
}
