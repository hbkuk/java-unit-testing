package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class bj20920 {
    
    /**
     * 단어장 만들기
     */
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        
        // TODO 1. 입력 받기(Buffered Reader 사용)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 영어 지문에 나오는 단어의 개수
        int M = Integer.parseInt(st.nextToken()); // 외울 단어의 길이 기준이 되는 숫자
        
        Map<String, Integer> wordMap = new HashMap<>(); // 단어와 노출 빈도 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            
            wordMap.put(input, wordMap.getOrDefault(input, 0) + 1);
        }
        
        // TODO 2. 단어 정렬하기 -> Map으로 카운트 저장? 필요시 Set 자료구조로 사용?
        Set<String> wordSet = new HashSet<>(wordMap.keySet());
        //  - 0) M 보다 작은 길이의 단어 삭제
        //      - 변수명 'validateWords'
        wordSet.removeIf(word -> word.length() < M);
        
        List<String> wordList = new ArrayList<>(wordSet);
        
        //  - 1) 빈도 많은 순
        //      - 단어별 빈도수 저장 필요
        //  - 2) 단어 길이 많은 순
        //      - Comparator 클래스 구현 필요(@Override compare)
        //  - 3) 알파벳 사전 순
        //      - Comparator 클래스 구현 필요(@Override compare)
        wordList.sort(new Comparator<String>() {
            
            @Override
            public int compare(String o1, String o2) {
                int frequencyCompare = Integer.compare(wordMap.get(o2), wordMap.get(o1));
                if (frequencyCompare != 0) {
                    return frequencyCompare;
                    
                }
                
                int lengthCompare = Integer.compare(o2.length(), o1.length());
                if (lengthCompare != 0) {
                    return lengthCompare;
                }
                
                return o1.compareTo(o2);
            }
        });
        
        // TODO 3. 상위 M개 추출하기
        for (int i = 0; i < wordList.size(); i++) {
            sb.append(wordList.get(i));
            sb.append("\n");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
    
}
