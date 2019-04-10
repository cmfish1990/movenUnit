/*
 * cf
 * FileName: DoubleLink.java
 * Author:   BM
 * Date:     2019-05-25 13:19:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-25 13:19:13> <version> <desc> <source>
 *
 */

package wk.lear.datastructure;

public class DoubleLink<T> {
    public Node<T> first;
    public Node<T> last;
    public int size;


    private class Node<T> {
        public T value;
        public Node prev;
        public Node next;
        public Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
