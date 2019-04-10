/*
 * cf
 * FileName: FourSortRun.java
 * Author:   BM
 * Date:     2019-05-20 12:34:31
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-20 12:34:31> <version> <desc> <source>
 *
 */

package wk.lear.sort;

import java.util.Arrays;

/**
 * Created by bm on 18-5-20.
 */
public class FourSortRun {

    public static void main(String[] args) {
        int[] a = {20,40,30,10,60,50,22,34,12,45,54,25};
      //  bubbleSort(a);
    //    selectSort(a);
    //    quickSort(a,0,a.length-1);
        insertSort(a);
    }

    /**
     * 冒泡排序
     */
    public static void bubbleSort(int a[]){
        int length=a.length;
        for(int i=length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
                System.out.println(Arrays.toString(a));
            }
        }
    }

    /**
     * 選擇排序
     * @param a
     */
    public static void selectSort(int a[]){
         int length=a.length;
         for(int i=0;i<length;i++){
             int index=i;
             for(int j=i;j<length;j++){
                 if(a[index]>a[j]){
                     index=j;
                 }
             }
             if(i!=index){
                 int temp=a[i];
                 a[i]=a[index];
                 a[index]=temp;
             }
             System.out.println(Arrays.toString(a));
         }
    }

    /**
     * 快速排序
     * @param a
     */
    public static void quickSort(int a[],int l,int r ){
        if(l<r){
            int i=l;
            int j=r;
            int ar=a[l];
            while(i<j) {
                while (i < j && a[j] > ar)
                    j--;
                if (i < j) {
                    a[i] = a[j];
                }
                while (i < j && a[i] < ar)
                    i++;
                if (i < j) {
                    a[j] = a[i];
                }
            }
            a[i]=ar;
            quickSort(a,l,i-1);
            quickSort(a,i+1,r);
            System.out.println(Arrays.toString(a));
        }

    }

    /**
     * 插入排序
     */
    public static void insertSort(int a[]){
        for(int i=1;i<a.length;i++){
            int index=i;
            for(int j=0;j<i;j++){
                if(a[j]>a[i]){
                    index=j;
                    break;
                }
            }
            if(index!=i){
                int temp=a[i];
               for(int j=i;j>index;j--){
                   a[j]=a[j-1];
               }
               a[index]=temp;
            }
            System.out.println(Arrays.toString(a));
        }
    }

    /**
     *
     */
}
