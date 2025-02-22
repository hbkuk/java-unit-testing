package backjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class bj2531_2 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        String[] line = scan.nextLine().split(" ");
        int N = Integer.parseInt(line[0]); // 벨트에 놓인 접시의 개수
        int d = Integer.parseInt(line[1]); // 초밥의 가지수
        int k = Integer.parseInt(line[2]); // 연속해서 먹는 접시의 개수
        int c = Integer.parseInt(line[3]); // 쿠폰 번호
        
        int[] tables = new int[N];
        for (int i = 0; i < N; i++) {
            tables[i] = Integer.parseInt(scan.nextLine());
        }
        
        // TODO 예외 체크
        //  1) 벨트에 놓인 접시의 개수보다 k가 더 클 경우..?
        
        // 가짓수의 최댓값
        int maxCount = 0;
        
        for (int i = 0; i < N; i++) {
            Set<Integer> numbers = new HashSet<>();
            
            for (int j = i; j < i + k; j++) {
                int currentIndex = getCurrentIndex(j, N);
                numbers.add(tables[currentIndex]);
            }
            
            maxCount = Math.max(numbers.size(), maxCount);
            
            int leftTable = getCurrentIndex(i - 1, N);
            int rightTable = getCurrentIndex(i + k, N);
            
            if (numbers.contains(c)) { // 먹은 접시에 쿠폰 번호 있음 처리
                if (!numbers.contains(tables[leftTable]) || !numbers.contains(tables[rightTable])) {
                    maxCount = Math.max(numbers.size(), maxCount + 1);
                }
            } else { // 먹은 접시에 쿠폰 번호 없음 처리
                if (tables[leftTable] == c || tables[rightTable] == c) {
                    maxCount = Math.max(numbers.size(), maxCount + 1);
                }
                
            }
        }
        
        System.out.println(maxCount);
    }
    
    private static int getCurrentIndex(int currentIndex, int maxLength) {
        if (currentIndex >= maxLength) { // length 8 -> currentIndex 8 -> index 0
            return currentIndex - maxLength; // 회전 테이블로 보정
        } else if (currentIndex <= -1) { // length 8 -> currentIndex -1 -> index 8
            return (maxLength + currentIndex) + 1; // 회전 테이블로 보정
        }
        return currentIndex;
    }
}
