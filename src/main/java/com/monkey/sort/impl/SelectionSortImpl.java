package com.monkey.sort.impl;

import com.monkey.sort.IArraySort;

import java.util.Arrays;

/**
 * 选择排序
 * @author tao
 */
public class SelectionSortImpl implements IArraySort {
    /**
     * 选择排序
     *
     * @param sourceArray 待排序数组
     * @return 排序后数组
     */
    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);

        int tmp;
        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            if (min != i) {
                // 交换位置
                tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
        }
        return array;
    }
}
