package com.monkey.sort;

import org.junit.Test;

import java.util.Arrays;

public class TestSort {

    //private int[] sourceArray = {20, 1, 8, 9, 3, 4, 17, 12, 11, 2, 7, 15, 19};
    private int[] sourceArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    @Test
    public void testBubbleSort() {
        IArraySort arraySort = new BubbleSort();
        System.out.println(Arrays.toString(sourceArray));
        int[] targetArray = arraySort.sort(sourceArray);
        System.out.println(Arrays.toString(targetArray));
    }
}
