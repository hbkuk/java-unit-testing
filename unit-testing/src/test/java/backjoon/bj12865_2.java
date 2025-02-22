package backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj12865_2 {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 물품의 개수
        int K = scan.nextInt(); // 준서가 버틸 수 있는 무게
        
        int[][] products = new int[N][2]; // 각 물건 목록(무게 W, 가치 V)
        for(int i = 0; i < N; i++) {
            products[i][0] = scan.nextInt();
            products[i][1] = scan.nextInt();
        }
        
        Arrays.sort(products, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] o1, int[] o2) {
              return o1[0] - o2[0];
            };
        });
        
        int[] dp = new int[K + 1];
        dp[0] = 0;
        
        for(int i = 0; i < N; i++) {
            int weight = products[i][0]; // 무게
            int value = products[i][1];  // 가치
            
            for(int j = K; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }
        
        int maxValue = 0;
        for(int i = 0; i <= K; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        
        System.out.println(maxValue);
    }
}
