package com.monkey.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class TestSort {

    //private int[] sourceArray = {20, 1, 8, 9, 3, 4, 17, 12, 11, 2, 7, 15, 19};
    private int[] sourceArray = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    private IArraySort arraySort;

    @Before
    public void beforeTest() {
        System.out.println(Arrays.toString(sourceArray));
    }

    @After
    public void afterTest() {
        int[] targetArray = arraySort.sort(sourceArray);
        System.out.println(Arrays.toString(targetArray));
    }

    @Test
    public void testBubbleSort() {
        arraySort = new BubbleSort();
    }

    @Test
    public void testSelectionSort() {
        arraySort = new SelectionSort();
    }

    @Test
    public void testInsertionSort() {
        arraySort = new InsertionSort();
    }
}
