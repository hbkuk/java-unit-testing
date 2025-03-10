package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

    public static int correctString(String s) {
        int countOfCorrectString = 0;

        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();
        for (int i = 1; i <= chars.length; i++) {
            if (i != 1) {
                stringRotation(chars);
            }

            for (char c : chars) {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    char preChar = stack.peek();
                    if (preChar == '(') {
                        if (c == ')') {
                            stack.pop();
                            continue;
                        }
                    } else if (preChar == '[') {
                        if (c == ']') {
                            stack.pop();
                            continue;
                        }
                    } else if (preChar == '{') {
                        if (c == '}') {
                            stack.pop();
                            continue;
                        }
                    }
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                countOfCorrectString++;
            }
            stack.clear();
        }
        return countOfCorrectString;
    }

    public static int saleProduct(String[] want, int[] number, String[] discount) {
        // 초기 포인터 설정
        int start = 0;
        int end = 9;

        // 결과
        int result = 0;

        // want, number map 변환
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i <= want.length - 1; i++) {
            wantMap.put(want[i], number[i]);
        }

        // 초기 10일에 dicsount를 품목 정리해보기
        Map<String, Integer> discountMap = new HashMap<>();
        for(int i = 0; i <= 9; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }

        // while문 종료 시점 => end == discount.length -1
        while(end  <= discount.length - 1) {

            // 1. 등록 확인하기
            // - 배열 하나하나 꺼내서 확인
            boolean allProductsMatch = true;

            for (Map.Entry<String, Integer> entry : wantMap.entrySet()) {
                String wantKey = entry.getKey();
                int wantValue = entry.getValue();

                if (wantValue != discountMap.getOrDefault(wantKey, 0)) {
                    // 하나라도 일치하지 않는 경우
                    allProductsMatch = false;
                    break;
                }
            }

            // 모든 제품이 일치할 때만 result를 증가
            if (allProductsMatch) {
                result++;
            }

            // 2. dicsount 정리
            if(end + 1 <= discount.length - 1) {
                // 현재 start에 해당하는 상품을 discountMap에서 --
                // 현재 end에 해당하는 상품을 discountMap에서 --
                discountMap.put(discount[start], discountMap.get(discount[start]) - 1);
                discountMap.put(discount[end + 1], discountMap.getOrDefault(discount[end + 1], 0) + 1);
            }

            // 3. 포인터 이동, 포인터 넘치면 while문에서 break
            start ++;
            end ++;
        }

        return result;
    }


    private static void stringRotation(char[] chars) {
        char tempChar = chars[0];
        System.arraycopy(chars, 1, chars, 0, chars.length - 1);
        chars[chars.length - 1] = tempChar;
    }

}

