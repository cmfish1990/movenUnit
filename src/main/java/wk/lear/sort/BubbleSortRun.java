/*
 * cf
 * FileName: BubbleSortRun.java
 * Author:   BM
 * Date:     2019-05-17 12:52:25
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-17 12:52:25> <version> <desc> <source>
 *
 */

package wk.lear.sort;

import java.util.Arrays;

/**
 * bubble sort 冒泡排序
 *  稳定
 *  数据移动次数多
 *
 */
public class BubbleSortRun {

    public static void main(String[] args) {
        Long before=  System.nanoTime();
        int[] a = {20,40,30,10,60,50,22,34,12,45,54,25};
        bubbleSort(a);
        Long end=System.nanoTime();
        System.out.println("time:"+(end-before));
    }

  private static void bubbleSort(int a[]){
      int length=a.length;
      int commpareCount=0;
      int changeCount=0;
      for(int i=length-1;i>0;i--){
          System.out.println(Arrays.toString(a));
          for(int j=0;j<i;j++){
              commpareCount++;
              if(a[j]>a[j+1]){
                  int temp=a[j];
                  a[j]=a[j+1];
                  a[j+1]=temp;
                  changeCount++;
                  System.out.println(Arrays.toString(a));
              }
          }
      }
      System.out.println("compare:"+commpareCount);
      System.out.println("change:"+changeCount);
  }
}
