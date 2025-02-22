package programmers;

import java.util.*;
import org.junit.jupiter.api.Test;

public class Solution {
    
    @Test
    void 테스트() {
        int solution = solution("aab", "aba", new String[]{"abb", "aba"});
        System.out.println("solution" + solution);
    }
    
    public static int solution(String begin, String target, String[] words) {
        int answer = words.length;
        boolean isFind = false;
        
        if (!Arrays.asList(words).contains(target)) {
            return 0; // target이 words에 없으면 변환 불가능
        }
        
        for(int i = 0; i < words.length; i++) {
            
            // 한 글자만 다른 경우 => bfs를 호출한다.
            String word = words[i];
            
            int matchCount = begin.length();
            for(int j = 0; j < word.length(); j++) {
                
                if(begin.charAt(j) == word.charAt(j) ) { // 같은 문자인 경우 -1
                    matchCount --;
                }
            }
            
            // 알파벳 하나만 다를 경우
            if(matchCount == 1) {
                int result = bfs(target, words, i, 1);// 목표 글자, 문자 배열, 현재 인덱스, 바꾼 횟수
                if(result != Integer.MAX_VALUE) {
                    answer = Math.min(answer, result);
                    isFind = true;
                }
            }
        }
        
        if(isFind) {
            return answer;
        }
        return 0;
    }
    
    public static int bfs(String target, String[] words, int currentIndex, int chageNumber) {
        Queue<int[]> queue = new LinkedList<>(); // 현재 글자 인덱스, 바꾼 횟수
        queue.offer(new int[]{currentIndex, chageNumber});
        
        while(!queue.isEmpty()) { // 큐가 빌때까지 진행
            
            int[] current = queue.poll();
            int cIndex = current[0];
            int cChangeNumber = current[1];
            
            // 큐에서 꺼낸 글자가 target과 동일할 경우
            if(words[cIndex].equals(target)) {
                return cChangeNumber;
            }
            
            for(int i = cIndex + 1; i < words.length; i++) {
                String word = words[i];
                
                int matchCount = word.length();
                for(int j = 0; j < word.length(); j++) {
                    
                    if(words[cIndex].charAt(j) == word.charAt(j) ) { // 같은 문자인 경우 -1
                        matchCount --;
                    }
                }
                
                // 알파벳 하나만 다를 경우
                if(matchCount == 1) {
                    queue.offer(new int[]{i, cChangeNumber + 1});
                }
                
            }
        }
        
        return Integer.MAX_VALUE;
    }
}
