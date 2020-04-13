package com.monkey.sort;

import com.monkey.sort.impl.*;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class TestSort {

    private int[] sourceArray;

    private IArraySort arraySort;

    private void generateRandomArray() {
        Random r = new Random();
        sourceArray = new int[10000];

        for (int i = 0; i < sourceArray.length; i++) {
            sourceArray[i] = r.nextInt(10000);
        }
    }

    @Before
    public void beforeTest() {
        generateRandomArray();
        System.out.println(Arrays.toString(sourceArray));
    }

    @After
    public void afterTest() {
        int[] targetArray = arraySort.sort(sourceArray);

        Arrays.sort(sourceArray);

        boolean same = true;
        for (int i = 0; i < targetArray.length; i++) {
            if (sourceArray[i] != targetArray[i]) {
                same = false;
                break;
            }
        }
        System.out.println(Arrays.toString(targetArray));
        if (same) {
            System.out.println("success");
        } else {
            System.out.println("error");
        }
    }

    @Test
    public void testBubbleSort() {
        arraySort = new BubbleSortImpl();
    }

    @Test
    public void testSelectionSort() {
        arraySort = new SelectionSortImpl();
    }

    @Test
    public void testInsertionSort() {
        arraySort = new InsertionSortImpl();
    }

    @Test
    public void testShellSort() {
        arraySort = new ShellSortImpl();
    }

    @Test
    public void testMergeSort() {
        arraySort = new MergeSortImpl();
    }

    @Test
    public void testQuickSort() {
        arraySort = new QuickSortImpl();
    }

    @Test
    public void testCountingSort() {
        arraySort = new CountingSortImpl();
    }

    @Test
    public void testRadixSort() {
        arraySort = new RadixSortImpl();
    }
}
