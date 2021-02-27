package io.github.kji6252;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class BinarySearch {

    @Test
    void shouldBinarySearch() {
        int[] ints = IntStream.rangeClosed(1, 9).toArray();

        System.out.println("없으면 -1, 있으면 위치 반환 위치값=" + binarySearch(ints, 4, 0, ints.length -1));
        System.out.println("없으면 -1, 있으면 위치 반환 위치값=" + binarySearch(ints, 10, 0, ints.length -1));
    }

    private int binarySearch(int[] ints, int target, int start, int end) {
        int mid = (start + end) / 2;

        while (start <= end) {
            if(target == ints[mid]) {
                return mid;
            } else if(target < ints[mid]) {
                end = mid - 1;
                mid = (start + end) / 2;
            } else if(target > ints[mid]) {
                start = mid + 1;
                mid = (start + end) / 2;
            }
        }

        return -1;
    }
}
