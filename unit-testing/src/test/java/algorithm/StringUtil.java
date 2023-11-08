package algorithm;

import java.util.Arrays;

public class StringUtil {

    public static int toIntFromString(String str) {
        // O(N), 문자열의 길이에 비례한 시간이 소요
        char[] strArr = str.toCharArray();
        int base = 0;

        // O(N), 문자열의 길이에 비례한 시간이 소요
        for (char c : strArr) {
            base *= 10;
            base += c - '0';
        }

        // 전체 시간복잡도 => O(N)
        return base;
    }

    public static String reverseString(String str) {
        // O(N), 문자열의 길이에 비례한 시간이 소요
        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length - 1;

        // O(N/2), 문자열 길이에 절반만큼 반복
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;

            left++;
            right--;
        }

        // 전체 시간복잡도 => O(N)
        return new String(charArray);
    }

    public static boolean uniqueCharacterInString(String str) {
        // 1. 문자열을 문자 배열로 변환
        char[] charArray = str.toCharArray(); // O(N)

        // 2. 이중 루프를 사용하여 중복 문자 확인
        for (int i = 0; i < charArray.length - 1; i++) { // O(N-1)
            for (int j = i + 1; j < charArray.length; j++) { // O(N-1)
                // 3. 문자 비교
                if (charArray[i] == charArray[j]) { // O(1)
                    return false;
                }
            }
        }
        // 4. 전체 시간 복잡도 계산: O(N) * O(N-1) * O(N-1) * O(1) = O(N^2)
        return true;
    }


    public static boolean isAnagram(String firstWord, String secondWord) {
        // O(1), 상수 시간에 작동
        if (firstWord.length() != secondWord.length()) {
            return false;
        }

        // O(N), 문자열의 길이에 비례한 시간이 소요
        char[] charArray1 = firstWord.toCharArray();
        // O(N), 문자열의 길이에 비례한 시간이 소요
        char[] charArray2 = secondWord.toCharArray();

        // O(N * log(N)), 퀵소트 혹은 그리디 사용
        Arrays.sort(charArray1);
        // O(N * log(N)), 퀵소트 혹은 그리디 사용
        Arrays.sort(charArray2);

        // 전체 시간복잡도 => O(N * log(N))
        return Arrays.equals(charArray1, charArray2);
    }

    public static String characterCompressWithLength(String str) {

        // O(1), 상수 시간에 작동
        if (str == null || str.length() == 0) {
            return null;
        }

        // O(N), 문자열의 길이에 비례한 시간이 소요
        char[] charArray = str.toCharArray();
        // O(N * log(N)), 퀵소트 혹은 그리디 사용
        Arrays.sort(charArray);

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        // O(N), 문자열의 길이에 비례한 시간이 소요
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == charArray[i - 1]) {
                count++;
            } else {
                compressed.append(charArray[i - 1]);
                compressed.append(count);
                count = 1;
            }
        }

        compressed.append(charArray[charArray.length - 1]);
        compressed.append(count);

        // 전체 시간복잡도 => O(N * log(N))
        return compressed.toString();
    }

    public static int frequencyStringInDocument(String[] strArr, String str) {
        // O(1), 상수 시간 동작
        if (strArr.length == 0) {
            return 0;
        }
        // O(1), 상수 시간 동작
        if (str == null || str.length() == 0) {
            return 0;
        }

        int frequency = 0;
        // O(N), 문자열의 길이에 비례한 시간이 소요
        for (String s : strArr) {
            if (s != null && s.equals(str)) {
                frequency++;
            }
        }
        // 전체 시간복잡도 => O(N)
        return frequency;
    }
}
