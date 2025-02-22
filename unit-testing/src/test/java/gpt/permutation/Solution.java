package gpt.permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    
    /**
     * 주어진 문자열 "abc"의 모든 순열을 반환합니다.
     *
     * @param s 순열을 구할 문자열
     * @return 모든 순열 리스트
     */
    public List<String> getPermutations1(String s) {
        List<String> list = new ArrayList<>();
        permutations1("", s, s.length(), list);
        
        return list;
    }
    
    private void permutations1(String prefix, String remainStr, int length, List<String> list) {
        if (prefix.length() == length) {
            list.add(prefix);
            return;
        }
        
        for (int i = 0; i < remainStr.length(); i++) {
            permutations1(
                prefix + remainStr.charAt(i),
                remainStr.substring(0, i) + remainStr.substring(i + 1),
                length, list);
        }
    }
    
    
    /**
     * 중복 문자가 포함된 문자열 "aab"의 모든 순열을 반환합니다.
     *
     * @param s 순열을 구할 문자열
     * @return 모든 순열 리스트 (중복 제거)
     */
    public List<String> getPermutations2(String s) {
        Set<String> set = new HashSet<>();
        permutations2("", s, s.length(), set);
        
        return new ArrayList<>(set);
    }
    
    private void permutations2(String prefix, String remainStr, int length, Set<String> set) {
        if (prefix.length() == length) {
            set.add(prefix);
        }
        
        for (int i = 0; i < remainStr.length(); i++) {
            permutations2(
                prefix + remainStr.charAt(i),
                remainStr.substring(0, i) + remainStr.substring(i + 1),
                length, set);
        }
    }
    
    public List<int[]> getPermutations3(int[] arr) {
        List<int[]> list = new ArrayList<>();
        permutations3(new ArrayList<>(), arr, arr.length, list);
        
        return list;
    }
    
    private void permutations3(List<Integer> result, int[] remain, int length, List<int[]> list) {
        if(result.size() == length) {
            list.add(result.stream().mapToInt(i -> i).toArray());
            return;
        }
        
        for(int i = 0; i < remain.length; i++) {
            // 요소 추가하기
            result.add(remain[i]);
            
            // 새로운 remain 배열을 만들 때, i번째 요소를 제외
            int[] newRemain = new int[remain.length - 1];
            for (int j = 0, k = 0; j < remain.length; j++) {
                if(remain[i] != remain[j]) {
                    newRemain[k++] = remain[j];
                }
            }
            
            permutations3(result, newRemain, length, list);
            
            result.remove(result.size() - 1);
        }
    }
    
    public List<int[]> getPermutations4(int[] arr) {
        List<int[]> list = new ArrayList<>();
        permutations4(new int[arr.length], arr, 0, list);
        
        
        return list;
    }
    
    private void permutations4(int[] result, int[] remain, int depth, List<int[]> list) {
        if (depth == result.length) {
            list.add(result.clone());
            return;
        }
        
        for (int i = 0; i < remain.length; i++) {
            result[depth] = remain[i]; // 값 추가
            
            permutations4(result, remain, depth + 1, list);
        }
    }
    
}

