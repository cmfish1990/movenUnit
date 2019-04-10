/*
 * cf
 * FileName: LinkedListRun.java
 * Author:   BM
 * Date:     2019-05-25 15:27:51
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-25 15:27:51> <version> <desc> <source>
 *
 */

package wk.lear.collection.list;


public class LinkedListRun {
    public static void main(String[] args) {
        ExLikedList ex=new ExLikedList();
        ex.addFirst(1);
        ex.addFirst(4);
        ex.addFirst(3);
        ex.add(2,2);
        System.out.println(ex.size());
        ExLikedList.Node fristNode=ex.getFirstNode();
        ExLikedList.Node lastNode=ex.getLastNode();
        System.out.println("--------------------");
    }
}
