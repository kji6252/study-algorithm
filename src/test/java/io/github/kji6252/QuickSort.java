package io.github.kji6252;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {
    @Test
    void quickSort() {
        int[] ints = {4, 5, 7, 1, 3, 9};

        quickSort(ints, 0, ints.length - 1);

        System.out.println(
            Arrays.stream(ints)
                  .mapToObj(String::valueOf)
                  .collect(Collectors.joining(",")));
    }

    private void quickSort(int[] ints, int left, int right) {
        int index = partition(ints, left, right);
        if (left < index - 1) {
            quickSort(ints, left, index - 1);
        }
        if (index < right) {
            quickSort(ints, index, right);
        }
    }

    private int partition(int[] ints, int left, int right) {
        int pivot = ints[(left + right) / 2];

        while (left <= right) {
            while (ints[left] < pivot) left++;
            while (ints[right] > pivot) right--;

            if (left <= right) {
                swap(ints, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private void swap(int[] ints, int left, int right) {
        int temp = ints[left];
        ints[left] = ints[right];
        ints[right] = temp;
    }
}
