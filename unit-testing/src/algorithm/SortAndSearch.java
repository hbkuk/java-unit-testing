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
            for (int j = i; j >= 1; j--) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        // 최종 시간 복잡도 => O((N-1) * N / 2 * O(1)) = O(N^2)
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        int minElement = 0; // 최소값
        int minElementIndex = 0; // 최소값의 인덱스
        int temp = 0; // 임시 저장 변수

        // O(N) 만큼의 시간 소요
        for (int currentIndex = 0; currentIndex < arr.length - 1; currentIndex++) {
            minElement = arr[currentIndex];
            minElementIndex = currentIndex;
            temp = arr[currentIndex];

            // O(N - 1) 만큼의 시간 소요
            for (int i = currentIndex + 1; i < arr.length; i++) {
                if (minElement > arr[i]) {
                    minElement = arr[i];
                    minElementIndex = i;
                }
            }

            arr[currentIndex] = minElement;
            arr[minElementIndex] = temp;
        }

        // 최종 시간 복잡도 = > O( N * (N - 1)) = O(N^2)
        return arr;
    }

    public static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pivot 선택에서 가장 큰 수를 선택 시 최악의 경우 O(N)
            int partitionIdx = partition(arr, low, high);

            // 최악 시간 복잡도 O(n)
            quickSort(arr, low, partitionIdx - 1);
            quickSort(arr, partitionIdx + 1, high);
        }

        // 최종 시간 복잡도
        // Best, Average : O(n * log(n))
        // Worst : O(N^2)
        return arr;
    }

    private static int partition(int[] arr, int left, int right) {
        int swapIdx = left - 1;
        int pivotValue = arr[right];
        int swapValue = 0;

        for (int currentIndex = left; currentIndex <= right; currentIndex++) {
            if (pivotValue > arr[currentIndex]) {
                swapIdx++;
                swapValue = arr[currentIndex];
                arr[currentIndex] = arr[swapIdx];
                arr[swapIdx] = swapValue;
            }
        }
        swapIdx++;
        swapValue = arr[swapIdx];
        arr[swapIdx] = arr[right];
        arr[right] = swapValue;

        return swapIdx;
    }

    public static int[] countingSort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }

        int maxValue = 0;

        // O(N) 만큼의 시간복잡도 소요
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        int[] countingArray = new int[maxValue + 1];

        // O(N) 만큼의 시간 복잡도 소요
        for (int value : arr) {
            countingArray[value]++;
        }

        int[] prefixSumArray = new int[maxValue + 1];
        int sum = 0;

        // O(N) 만큼의 시간 복잡도 소요
        for (int i = 0; i <= prefixSumArray.length - 1; i++) {
            sum += countingArray[i];
            prefixSumArray[i] = sum - 1;
        }

        int[] sortedArray = new int[arr.length];

        // O(N) 만큼의 시간 복잡도 소요
        for (int value : arr) {
            int idx = prefixSumArray[value];
            prefixSumArray[value]--;
            sortedArray[idx] = value;
        }

        // 최종 시간 복잡도 => O(N)!!
        return sortedArray;
    }

    public static int[] radixSort(int[] arr) {
        return arr;
    }
}
