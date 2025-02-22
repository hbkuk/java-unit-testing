package backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj8979_2 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 국가의 수
        int K = scan.nextInt(); // 등수를 알고 싶은 국가
        scan.nextLine();
        
        // 1: 각 국가별 금/은/동 수 입력받기
        int[][] medals = new int[N][4]; // [국가 번호, 금메달 수, 은메달 수, 동메달 수]
        for (int i = 0; i < N; i++) {
            int 국가_번호 = scan.nextInt();
            int 금메달_수 = scan.nextInt();
            int 은메달_수 = scan.nextInt();
            int 동메달_수 = scan.nextInt();
            scan.nextLine();
            
            medals[i][0] = 국가_번호;
            medals[i][1] = 금메달_수;
            medals[i][2] = 은메달_수;
            medals[i][3] = 동메달_수;
            
            // System.out.println(국가_번호 + " " + 금메달_수 + " " + 은메달_수 + " " + 동메달_수);
        }
        
        // 2: 국가별 금/은/동 수 내림차순 정렬
        Arrays.sort(medals, (a, b) -> {
            if (b[1] != a[1]) return b[1] - a[1]; // 금메달 내림차순
            if (b[2] != a[2]) return b[2] - a[2]; // 은메달 내림차순
            return b[3] - a[3]; // 동메달 내림차순
        });
        
        int lastLank = 1;
        // 순위 매기기(단, 금/은/동 수가 같을 경우 동일한 순위)
        //  - 자신보다 더 잘한 나라 수 + 1
        for(int i = 0; i < N; i++) {
            if(i > 0) {
                int 이전_금메달_수 = medals[i - 1][1];
                int 이전_은메달_수 = medals[i - 1][2];
                int 이전_동메달_수 = medals[i - 1][3];
                
                int 현재_금메달_수 = medals[i][1];
                int 현재_은메달_수 = medals[i][2];
                int 현재_동메달_수 = medals[i][3];
                
                if(이전_금메달_수 != 현재_금메달_수 || 이전_은메달_수 != 현재_은메달_수 || 이전_동메달_수 != 현재_동메달_수) {
                    lastLank = i + 1;
                }
            }
            
            
            if(medals[i][0] == K) {
                System.out.println(lastLank);
                return;
            }
        }
    }
    
}
