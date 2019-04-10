/*
 * cf
 * FileName: MergeSortRun.java
 * Author:   BM
 * Date:     2019-05-20 18:03:43
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-20 18:03:43> <version> <desc> <source>
 *
 */

package wk.lear.sort;

import java.util.Arrays;

/**
 * Created by bm on 18-5-20.
 */
public class MergeSortRun {

    public static void main(String[] args) {
        int[] a = {20,40,30,10,60,50,22,34,12,45,54,25};
        //mergeSortDown2Up(a);
        mergeSortUp2Down(a,0,a.length-1);
    }
    public static void mergeSortDown2Up(int a[]){
        for(int i=1;i<a.length;i*=2){
            mergeGroup(a,a.length,i);
        }
    }

    public static void mergeSortUp2Down(int a[],int start,int end) {
        if (start < end) {
            int min = (start + end) / 2;
            mergeSortUp2Down(a, start, min);
            mergeSortUp2Down(a, min + 1, end);
            merge(a, start, min, end);
        }
    }
    public  static void mergeGroup(int a[],int len,int gap){
        int i;
        int twolen=2*gap;
        for(i=0;i+2*gap-1<len;i+=2*gap){
            merge(a,i,i+gap-1,i+2*gap-1);
        }
        if(i+gap-1<len-1){
            merge(a,i,i+gap-1,len-1);
        }
    }

    public static void merge(int a[], int start, int min, int end) {
        int temp[] = new int[end - start + 1];
        int i = start;
        int j = min + 1;
        int k = 0;
        while (i <= min && j <= end) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
            System.out.println(Arrays.toString(temp));
        }
        while(i<=min){
            temp[k++]=a[i++];
        }
        while(j<=end){
            temp[k++]=a[j++];
        }
        for (i = 0; i < k; i++)
            a[start + i] = temp[i];
        temp=null;
        System.out.println(Arrays.toString(a));
    }

}
