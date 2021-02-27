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
        if (left >= right) return;

        int pivot = partition(ints, left, right);

        quickSort(ints, left, pivot - 1);
        quickSort(ints, pivot + 1, right);
    }

    private int partition(int[] ints, int left, int right) {
        int middle = ints[(left + right -1) / 2];

        while (left <= right) {
            while (ints[left] < middle) left++;
            while (right > 0 && ints[right] >= middle) right--;

            if (left <= right) {
                int temp = ints[left];
                ints[left] = ints[right];
                ints[right] = temp;
                left++;
                right--;
            }
        }

        return left;
    }
}
