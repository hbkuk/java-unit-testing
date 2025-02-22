package backjoon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class bj20922 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 정수 개수
        int K = scan.nextInt(); // 같은 정수 K개 이하로 포함
        
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        
        // 초기 포인터
        int leftPointer = 0;
        int rightPointer = N - 1;
        
        // 같은 정수가 K개 이하인 요소가 없을 때까지 반복
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i = leftPointer; i < rightPointer; i++) {
            int currentNumber = arr[i];
            
            int count = map.getOrDefault(currentNumber, 0);
            map.put(currentNumber, count + 1);
            if(count >= K) {
                set.add(currentNumber);
            }
        }
        
        // set에 저장된 정보를 기반으로 포인터 줄이기
        
        
        System.out.println(rightPointer - leftPointer);
    }
    
}
