/*
 * cf
 * FileName: ExLikedList.java
 * Author:   BM
 * Date:     2019-05-25 16:02:36
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-25 16:02:36> <version> <desc> <source>
 *
 */

package wk.lear.collection.list;

import java.util.*;

public class ExLikedList<E> extends AbstractSequentialList<E> implements List<E>,Deque<E>,java.io.Serializable {


    transient int size = 0;
    public Node<E> first;
    public Node<E> last;

    /**
     *内部类
     * @param <E>
     */
    public static class Node<E>{
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(Node prev,E item,Node next){
            this.prev=prev;
            this.item=item;
            this.next=next;
        }
    }

    public boolean add(E e){
        linkLast(e);
        return true;
    }

    @Override
    public void add(int index, E e) {
        checkPositonIndex(index);
        if(index==size){
           linkLast(e);
        }else{
            linkBefore(e,node(index));
        }

    }

   void linkBefore(E e,Node<E> node){
       final Node<E> prev=node.prev;
       final Node<E>newNode=new Node(prev,e,node);
       node.prev=node;
       if(prev==null){
           first=newNode;
       }else{
           prev.next=newNode;
       }
       size++;
       modCount++;
   }


    void linkLast(E e){
        final Node<E> l=last;
        final Node<E> newNode=new Node<E>(last,e,null);
        last=newNode;
        if(l==null){
            first=last;
        }else{
            l.next=newNode;
        }
        modCount++;
        size++;
    }
    void linkFirst(E e){
        final Node<E> f=first;
        final Node<E> newNode=new Node<E>(null,e,first);
        first=newNode;
        if(f==null){
            last=first;
        }else{
            f.prev=newNode;
        }
        modCount++;
        size++;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public void addFirst(E e) {
     linkFirst(e);
    }

    @Override
    public void addLast(E e) {
        add(e);
    }

    @Override
    public boolean offerFirst(E e) {
      addFirst(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    @Override
    public E removeFirst() {
        final Node<E> f=first;
        if(f==null){
            throw new NoSuchElementException();
        }
      return  unLink(f);
    }

    @Override
    public E removeLast() {
        final Node<E> l=last;
        if(l==null){
            throw new NoSuchElementException();
        }
        return unLink(l);
    }

    @Override
    public boolean remove(Object o) {
        if(o==null){
            for(Node<E> x=first;x!=null;x=x.next){
                if(x.item==null){
                    unLink(x);
                    return true;
                }
            }
        }else{
            for(Node<E> x=first;x!=null;x=x.next){
                if(o.equals(x.item)){
                    unLink(x);
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public E pollFirst() {
        return null;
    }

    @Override
    public E pollLast() {
        return null;
    }

    @Override
    public E getFirst() {
        final  Node<E> e=first;
        if(null==e)
            throw new NoSuchElementException();
        return e.item;
    }

    @Override
    public E getLast() {
        final  Node<E> e=last;
        if(null==e)
            throw new NoSuchElementException();
        return e.item;
    }

    @Override
    public E peekFirst() {
        return null;
    }

    @Override
    public E peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E remove(int index) {
        checkPositonIndex(index);
        return unLink(node(index));
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public int size() {
        return  this.size;
    }

    @Override
    public Iterator<E> descendingIterator() {
        return null;
    }

    public Node getFirstNode(){
        return first;
    }

    public Node getLastNode(){
        return  last;
    }
    private boolean isPositionIndex(int index){
        return index >=0 &&index <size;
    }


    public void checkPositonIndex(int index){
        if(!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    Node<E> node(int index){
        if(index<(size>>1)){
            Node<E> x=first;
            for(int i=0;i<index;i++){
                x=x.next;
            }
            return x;
        }else{
           Node<E> x=last;
            for(int i=size-1;i>index;i--){
               x= x.prev;
            }
            return x;
        }
    }

    E unLink(Node<E> x){
        final E e=x.item;
        final Node<E>prev=x.prev;
        final Node<E>next=x.next;
        if(prev==null){
            first=next;
        }else{
            prev.next=next;
            x.prev=null;
        }
        if(next==null){
            last=prev;
        }else{
            next.prev=prev;
            x.next=null;
        }
        size--;
        x.item=null;
        modCount++;
        return e;
    }
}
