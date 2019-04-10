/*
 * Copyright (C),2015-2019.
 * FileName: GetLongDemo.java
 * Author:   BM
 * Date:     2019-10-11 15:00:50
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-10-11 15:00:50> <version> <desc> <source>
 *
 */

package wk.utils;


import javax.swing.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class GetLongDemo {
    public static void main(String[] args) {


        Long l= Long.getLong("sun.arch.data.model");

        Properties properties = System.getProperties();
        Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entrySet) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
            if(Long.getLong(entry.getKey()+"")!=null){
             System.out.println("==================" + Long.getLong(entry.getKey() + ""));
            }
        }
        System.out.println( l);
    }
}
