package algorithm;

public class SortAndSearch {

    public static int[] bubbleSort(int[] arr) {
        int temp = 0;
        // O(N-1)
        for (int i = 1; i <= arr.length - 1; i++) {
            // O((N-1) * N / 2)
            for (int j = 0; j <= arr.length - 1 - i; j++) {
                // O(1)
                if (arr[j + 1] < arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // 최종 시간 복잡도 => O((N-1) * N / 2 * O(1)) = O(N^2)
        return arr;
    }
    public static int[] insertingSort(int[] arr) {
        int temp = 0;

        // O(N-1)
        for (int i = 1; i <= arr.length - 1; i++) {
            // O((N-1) * N / 2)
           for( int j = i; j >= 1; j--) {
               if(arr[j-1] > arr[j]) {
                   temp = arr[j-1];
                   arr[j-1] = arr[j];
                   arr[j] = temp;
               }
           }
        }
        // 최종 시간 복잡도 => O((N-1) * N / 2 * O(1)) = O(N^2)
        return arr;
    }
}
