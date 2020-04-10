package com.monkey.sort.impl;

import com.monkey.sort.IArraySort;

import java.util.Arrays;

/**
 * 归并排序
 * @author tao
 */
public class MergeSortImpl implements IArraySort {
    /**
     * 归并排序
     *
     * @param sourceArray 待排序数组
     * @return 排序后数组
     */
    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);

        if (array.length < 2) {
            return array;
        }

        int middle = (int)Math.floor(sourceArray.length / 2);
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, sourceArray.length);

        return sortArray(sort(left), sort(right));
    }


    private int[] sortArray(int[] array1, int[] array2) {
        int[] array = new int[array1.length + array2.length];

        int i = 0, j = 0;
        int index = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] > array2[j]) {
                array[index++] = array2[j++];
            } else {
                array[index++] = array1[i++];
            }
        }

        while (i < array1.length) {
            array[index++] = array1[i++];
        }

        while (j < array2.length) {
            array[index++] = array2[j++];
        }

        return array;
    }
}
