

package wk.cityhome.dowork.work417;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbDemo {
    static String sql = null;
    static DBHelper db1 = null;
    static ResultSet ret = null;

    public static void main(String[] args) {
        sql = "select *from hotels";//SQL语句
        db1 = new DBHelper(sql);//创建DBHelper对象
         int count=0;
        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集
            while (ret.next()) {
                String uid = ret.getString("酒店商务设施");
                String ufname = ret.getString("酒店基本设施");
                String ulname = ret.getString("酒店安全设施");

                  if(uid.length()>0){
                    String fas[]=uid.split(",");
                      System.out.println(fas.length);
                    count+=fas.length;
                }

                if(ufname.length()>0){
                    String fas[]=ufname.split(",");
                    count+=fas.length;
                }

                if(ulname.length()>0){
                    String fas[]=ulname.split(",");
                    count+=fas.length;
                }

            }//显示数据
            System.out.println("==="+count);
            ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
