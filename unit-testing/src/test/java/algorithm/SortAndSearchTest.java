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

        int[] arr2 = {6, 4, 1, 8, 9, 2, 7, 5, 3};
        int[] sortedArr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(SortAndSearch.insertingSort(arr2)).isEqualTo(sortedArr2);

        int[] arr3 = {1};
        int[] sortedArr3 = {1};
        assertThat(SortAndSearch.insertingSort(arr3)).isEqualTo(sortedArr3);
    }

    @Test
    void selectionSortTest() {
        int[] arr1 = {};
        int[] sortedArr1 = {};
        assertThat(SortAndSearch.selectionSort(arr1)).isEqualTo(sortedArr1);

        int[] arr2 = {6, 4, 1, 8, 9, 2, 7, 5, 3};
        int[] sortedArr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(SortAndSearch.selectionSort(arr2)).isEqualTo(sortedArr2);

        int[] arr3 = {1};
        int[] sortedArr3 = {1};
        assertThat(SortAndSearch.selectionSort(arr3)).isEqualTo(sortedArr3);
    }

    @Test
    void quickSortTest() {
        int[] arr1 = {};
        int[] sortedArr1 = {};
        assertThat(SortAndSearch.quickSort(arr1, 0, arr1.length - 1)).isEqualTo(sortedArr1);

        int[] arr2 = {6, 4, 1, 8, 9, 2, 7, 5, 3};
        int[] sortedArr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(SortAndSearch.quickSort(arr2, 0, arr2.length - 1)).isEqualTo(sortedArr2);

        int[] arr3 = {1};
        int[] sortedArr3 = {1};
        assertThat(SortAndSearch.quickSort(arr3, 0, arr3.length - 1)).isEqualTo(sortedArr3);

        int[] arr4 = {6, 4, 2, 10, 9, 1, 7, 11, 5, 3, 0, 8};
        int[] sortedArr4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertThat(SortAndSearch.quickSort(arr4, 0, arr4.length - 1)).isEqualTo(sortedArr4);
    }

    @Test
    void countingSortTest() {
        int[] arr1 = {};
        int[] sortedArr1 = {};
        assertThat(SortAndSearch.countingSort(arr1)).isEqualTo(sortedArr1);

        int[] arr2 = {6, 4, 1, 8, 9, 2, 7, 5, 3};
        int[] sortedArr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(SortAndSearch.countingSort(arr2)).isEqualTo(sortedArr2);

        int[] arr3 = {1};
        int[] sortedArr3 = {1};
        assertThat(SortAndSearch.countingSort(arr3)).isEqualTo(sortedArr3);

        int[] arr4 = {6, 4, 2, 10, 9, 1, 7, 11, 5, 3, 0, 8};
        int[] sortedArr4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertThat(SortAndSearch.countingSort(arr4)).isEqualTo(sortedArr4);
    }

    @Test
    void radixSort() {
        int[] arr = new int[5];
        arr[0] = 52;
        arr[1] = 31;
        arr[2] = 24;
        arr[3] = 45;
        arr[4] = 13;

        int[] sortedArr = new int[arr.length];
        sortedArr[0] = 13;
        sortedArr[1] = 24;
        sortedArr[2] = 31;
        sortedArr[3] = 45;
        sortedArr[4] = 52;

        assertThat(SortAndSearch.radixSort(arr)).isEqualTo(sortedArr);
    }
}
