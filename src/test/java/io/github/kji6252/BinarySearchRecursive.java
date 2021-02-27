package io.github.kji6252;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

public class BinarySearchRecursive {

    @Test
    void shouldBinarySearch() {
        int[] ints = IntStream.rangeClosed(1, 9).toArray();

        System.out.println("없으면 -1, 있으면 위치 반환 위치값=" + binarySearch(ints, 4, 0, ints.length -1));
    }

    private int binarySearch(int[] ints, int target, int start, int end) {
        if(start > end) return -1;

        int mid = (start + end) / 2;

        if(target == ints[mid]) return mid;
        else if(target < ints[mid]) return binarySearch(ints, target, start, mid -1);
        else if(target > ints[mid]) return binarySearch(ints, target, mid +1, end);

        return -1;
    }
}
