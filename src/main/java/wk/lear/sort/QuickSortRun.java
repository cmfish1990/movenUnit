/*
 * cf
 * FileName: QuickSortRun.java
 * Author:   BM
 * Date:     2019-05-17 13:44:17
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-17 13:44:17> <version> <desc> <source>
 *
 */

package wk.lear.sort;

import java.util.Arrays;

public class QuickSortRun {
    public static void main(String[] args) {
        int[] a = {40, 10, 30, 11, 60, 50, 99, 12, 32, 22, 55, 45};
        quickSort(a,0,a.length-1);
    }


    private static void quickSort(int a[], int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            int x = a[l];
            while (i < j) {
                while (i < j && a[j] > x)
                    j--;
                if (i < j) {
                    a[i++] = a[j];
                }
                System.out.println(Arrays.toString(a));
                while (i < j && a[i] < x)
                    i++;
                if (i < j) {
                    a[j--] = a[i];
                }
                System.out.println(Arrays.toString(a));
              //  a[i]=x;
             //   quickSort(a,l,i-1);
             //   quickSort(a,i+1,r);

            }
            a[i]=x;
            quickSort(a,l,i-1);
             quickSort(a,i+1,r);
        }
    }
}
