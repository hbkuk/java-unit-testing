package backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj31246 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 전체 분석 광고 지면 수
        int K = scan.nextInt(); // 목표 낙찰 지면 수
        
        int[] info = new int[N]; // 0포함 양수인 경우 낙찰 가능, 음수인 경우 낙찰 불가
        for(int i = 0; i < N; i++) {
            int value1 = scan.nextInt(); // MOLOCO
            int value2 = scan.nextInt(); // 최고가
            
            info[i] = value1 - value2;
        }
        
        Arrays.sort(info);
        Integer[] infoArray = Arrays.stream(info).boxed().toArray(Integer[]::new);
        Arrays.sort(infoArray, Comparator.reverseOrder());
        
        
        int diff = infoArray[K - 1];
        // 0보다 큰 경우
        if(diff >= 0) {
            System.out.println(0);
        } else {
            System.out.println(Math.abs(diff));
        }
    }
}
