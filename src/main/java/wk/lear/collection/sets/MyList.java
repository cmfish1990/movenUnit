/*
 * cf
 * FileName: MyList.java
 * Author:   BM
 * Date:     2019-03-01 17:41:16
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-03-01 17:41:16> <version> <desc> <source>
 *
 */

package wk.lear.collection.sets;


public class MyList {

    public static void main(String[] args) {
//
//        ArrayListEx mylist=new ArrayListEx();
//
//
//        mylist.add(1);
//        System.out.println(mylist.getEleDate().length);
//        mylist.add(2);
//        System.out.println(mylist.getEleDate().length);
//        mylist.add(3);
//        System.out.println(mylist.getEleDate().length);
//        mylist.add(4);
//        System.out.println(mylist.getEleDate().length);
//        mylist.add(5);
//        System.out.println(mylist.getEleDate().length);
//        mylist.add(6);
//        System.out.println(mylist.getEleDate().length);
//        mylist.add(7);
//        System.out.println(mylist.getEleDate().length);
//        mylist.add(8);
//        mylist.add(9);
//        System.out.println(mylist.getEleDate().length);
//        mylist.add(10);
//        System.out.println(mylist.getEleDate().length);
//        mylist.add(11);
//        System.out.println(mylist.getEleDate().length);
//
//        for(int i=12;i<100;i++){
//            mylist.add(i);
//            System.out.println(i + ":" + mylist.getEleDate().length);
//            System.out.println(i+"="+mylist.getModelCount());
//        }
//       List list01=new ArrayList();
//         list01.add("hello");
//        System.out.println(list01.set(0,"world"));
//
//        List list02=new LinkedList();
//        list02.add("hello");
//        System.out.println(list02.set(0,"world"));


        LinkedListEx list03=new LinkedListEx();
        list03.add("hello");
        LinkedListEx.Node firstNode=list03.getFirstNode();
        list03.add("world");
        LinkedListEx.Node firstNode2=list03.getFirstNode();
        list03.add(" java");
        LinkedListEx.Node firstNode3=list03.getFirstNode();


        System.out.println(list03.getFirstNode().getItem());

    //    System.out.println(JSON.toJSONString(list03.getFirstNode()));

    }
}
