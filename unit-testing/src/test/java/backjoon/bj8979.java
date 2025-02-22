package backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj8979 {
    
    /**
     * 금메달 수가 더 많은 나라
     * 금메달 수가 같으면, 은메달 수가 더 많은 나라
     * 금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        // 메달 입력받기
        int[][] medals = new int[N][4];
        for (int i = 0; i < N; i++) {
            
            int nationalCode = sc.nextInt();
            int gold = sc.nextInt();
            int silver = sc.nextInt();
            int bronze = sc.nextInt();
            
            medals[i][0] = nationalCode;
            medals[i][1] = gold;
            medals[i][2] = silver;
            medals[i][3] = bronze;
        }
        
        // 메달 정렬하기
        Arrays.sort(medals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 금메달 수가 다르면
                if (o1[1] != o2[1]) {
                    return Integer.compare(o2[1], o1[1]);
                }
                
                // 금메달 수가 같고, 은메달 수가 다르면
                else if (o1[2] != o2[2]) {
                    return Integer.compare(o2[2], o1[2]);
                }
                
                // 은메달 수가 같고, 동메달 수가 다르면
                else {
                    return Integer.compare(o2[3], o1[3]);
                }
            }
        });
        
        int[] rank = new int[N + 1];
        // rank + 1 하면서, 순위 매기기
        int lastLank = 1;
        
        rank[medals[0][0]] = lastLank;
        for (int i = 1; i < N; i++) {
            
            if (medals[i - 1][1] != medals[i][1] ||
                medals[i - 1][2] != medals[i][2] ||
                medals[i - 1][3] != medals[i][3]) {
                
                lastLank ++;
            }
            
            rank[medals[i][0]] = lastLank;
        }
        
        // K에 해당하는 순위 출력하기
        System.out.println(rank[K]);
    }
}
