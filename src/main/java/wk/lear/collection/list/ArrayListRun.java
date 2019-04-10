/*
 * cf
 * FileName: ArrayListRun.java
 * Author:   BM
 * Date:     2019-05-13 22:23:48
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-13 22:23:48> <version> <desc> <source>
 *
 */

package wk.lear.collection.list;

import java.util.*;

/**
 * Created by bm on 18-5-13.
 */
public class ArrayListRun {
    public static void main(String[] args) {
        Set set=new HashSet();
        set.add(1);
        set.add(2);
        set.add(7);
        set.add(6);
        List list=new ArrayList(set);
        list.add(9);
     //   list.remove(2);

        Iterator it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println(list.toString());
    }
}
