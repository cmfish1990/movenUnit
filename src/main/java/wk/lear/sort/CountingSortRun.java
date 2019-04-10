/*
 * cf
 * FileName: CountingSortRun.java
 * Author:   BM
 * Date:     2019-05-20 23:43:38
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-20 23:43:38> <version> <desc> <source>
 *
 */

package wk.lear.sort;

import java.util.Arrays;

/**
 * Created by bm on 18-5-20.
 */
public class CountingSortRun {
    public static void main(String[] args) {
        int[] a = {20,40,30,10,60,50,22,34,12,45,54,25};
        countingSort(a);
    }
    public static void countingSort(int a[]){
       int max=getArrayMax(a);
       int temp[]=new int[max+1];
       for(int i=0;i<a.length;i++){
           temp[a[i]]++;
       }
       int i=0;
       for(int j=0;j<=max;j++){
           while(temp[j]!=0){
               a[i++]=j;
               temp[j]--;

               System.out.println(Arrays.toString(a)+"_________"+i);
           }
       }
        System.out.println(Arrays.toString(a));

    }

    public static int getArrayMax(int a[]){
//       int max = Arrays.stream(a).max().getAsInt();
//        return max;
        return 0;
    }
}
