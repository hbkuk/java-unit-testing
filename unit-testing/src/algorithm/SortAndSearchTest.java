package algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SortAndSearchTest {

    @Test
    void bubbleSortTest() {
        int[] arr = {2, 1, 4, 0, 3};
        int[] sortedArr = new int[arr.length];
        for (int i = 0; i < sortedArr.length; i++) {
            sortedArr[i] = i;
        }

        assertThat(SortAndSearch.bubbleSort(arr)).isEqualTo(sortedArr);
    }

    @Test
    void insertingSortTest() {
        int[] arr1 = {};
        int[] sortedArr1 = {};
        assertThat(SortAndSearch.insertingSort(arr1)).isEqualTo(sortedArr1);

        int[] arr2 = {6,4,1,8,9,2,7,5,3};
        int[] sortedArr2 = {1,2,3,4,5,6,7,8,9};
        assertThat(SortAndSearch.insertingSort(arr2)).isEqualTo(sortedArr2);

        int[] arr3 = {1};
        int[] sortedArr3 = {1};
        assertThat(SortAndSearch.insertingSort(arr3)).isEqualTo(sortedArr3);
    }
}
