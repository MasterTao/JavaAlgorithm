package com.monkey.sort.impl;

import com.monkey.sort.IArraySort;

import java.util.Arrays;

/**
 * 计数排序
 * @author tao
 */
public class CountingSortImpl implements IArraySort {
    /**
     * 计数排序
     *
     * @param sourceArray 待排序数组
     * @return 排序后数组
     */
    @Override
    public int[] sort(int[] sourceArray) {
        int[] array  = Arrays.copyOf(sourceArray, sourceArray.length);

        int maxValue = getMaxValue(array);

        return countingValue(array, maxValue);
    }

    private int getMaxValue(int[] array) {
        int maxValue = array[0];
        for (int value : array) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    private int[] countingValue(int[] array, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : array) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int i = 0; i < bucketLen; i++) {
            while (bucket[i] > 0) {
                array[sortedIndex++] = i;
                bucket[i]--;
            }
        }

        return array;
    }
}
