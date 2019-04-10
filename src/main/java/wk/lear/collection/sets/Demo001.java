/*
 * cf
 * FileName: Demo001.java
 * Author:   BM
 * Date:     2019-03-01 17:41:16
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-01 17:41:16> <version> <desc> <source>
 *
 */

package wk.lear.collection.sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class Demo001 {

    public static Object[] elementDate={0,1,2,3,4,5,6,7,9,10,null};


    public static void main(String[] args) {

      //remove(1);
    //    add(8,8);
        LinkedHashMap  map=new LinkedHashMap();
        map.put("234","abc");

       System.out.print("==========="+map.get(0));
    }

    public static void add(int index,Object obj){
        System.arraycopy(elementDate,index,elementDate,index+1,elementDate.length-index-1);
        elementDate[index]=obj;
        System.out.println(Arrays.toString(elementDate));

    }
    public static  void remove(int index){
        int size=elementDate.length-index-1;
        System.arraycopy(elementDate,index+1,elementDate,index,size);
        elementDate[elementDate.length-1]=null;
        System.out.println(Arrays.toString(elementDate));
        System.out.println(Arrays.toString(Arrays.copyOf(elementDate,elementDate.length-1)));
    }

}
