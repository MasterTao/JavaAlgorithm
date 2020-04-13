package com.monkey.sort.impl;

import com.monkey.sort.IArraySort;

import java.util.Arrays;

/**
 * 基数排序
 * @author tao
 */
public class RadixSortImpl implements IArraySort {
    /**
     * 基数排序
     *
     * @param sourceArray 待排序数组
     * @return 排序后数组
     */
    @Override
    public int[] sort(int[] sourceArray) {
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);
        int maxDigit = getMaxDigit(array);
        return radixSort(array, maxDigit);
    }

    private int[] radixSort(int[] array, int maxDigit) {
        int mod = 10;
        int dev = 1;

        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int item : array) {
                int bucket = ((item % mod) / dev) + mod;
                counter[bucket] = arrayAppend(counter[bucket], item);

            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    array[pos++] = value;
                }
            }
        }

        return array;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param array 数组
     * @param value 添加的值
     */
    private int[] arrayAppend(int[] array, int value) {
        array = Arrays.copyOf(array, array.length + 1);
        array[array.length - 1] = value;
        return array;
    }

    private int getMaxDigit(int[] array) {
        int maxValue = getMaxValue(array);
        return getNumberLength(maxValue);
    }

    private int getNumberLength(long number) {
        if (number == 0) {
            return 1;
        }

        int length = 0;
        for (long tmp = number; tmp > 0; tmp /= 10) {
            length++;
        }
        return length;
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
}
