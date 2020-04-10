package com.monkey.sort.impl;

import com.monkey.sort.IArraySort;

import java.util.Arrays;

/**
 * 希尔排序
 * @author tao
 */
public class ShellSortImpl implements IArraySort {
    /**
     * 希尔排序, 一种改进的插入排序
     *
     * @param sourceArray 待排序数组
     * @return 排序后数组
     */
    @Override
    public int[] sort(int[] sourceArray) {

        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);

        int gap = 1;
        while (gap < array.length / 3) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                int tmp = array[i];
                int j = i - gap;
                while (j >= 0 && array[j] > tmp) {
                    array[j + gap] = array[j];
                    j -= gap;
                }
                array[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }
        
        return array;
    }
}
