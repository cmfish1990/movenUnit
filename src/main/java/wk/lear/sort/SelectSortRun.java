/*
 * cf
 * FileName: SelectSortRun.java
 * Author:   BM
 * Date:     2019-05-17 13:01:13
 * Description: //模块目的、功能描述
 * History: //修改记录 修改人姓名 修改时间 版本号 描述 需求来源
 * BM <2019-05-17 13:01:13> <version> <desc> <source>
 *
 */

package wk.lear.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 移动数据的次数最大为n-1 比较少
 * 不稳定性
 *
 */
public class SelectSortRun {

    public static void main(String[] args) {
        Long before = System.nanoTime();
        int[] a = {20, 40, 30, 10, 60, 50, 22, 34, 12, 45, 54, 25};
        selectSort(a);
        Long end = System.nanoTime();
        System.out.println("time:" + (end - before));
    }

    private static void selectSort(int a[]) {
        int length = a.length;
        int commpareCount = 0;
        int changeCount = 0;
        for (int i = 0; i < length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                commpareCount++;
                if (a[j] < a[i]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
                changeCount++;
            }
            System.out.println(Arrays.toString(a));
        }
        System.out.println("compare:" + commpareCount);
        System.out.println("change:" + changeCount);
    }
}
