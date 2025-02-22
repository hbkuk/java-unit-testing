package backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj1931 {
    
    // 최대한 많은 회의를 선택하기 위한 방법
    //  회의 종료 시간이 가장 빠른 것을 선택한다.
    //  예) (1, 3) , (2, 5)
    //      (1, 3)을 선택할 경우 -> (3, 무한대)
    //      (2, 5)을 선택할 경우 -> (5, 무한대)
    //      => 결국엔 똑같이 회의실을 한번 사용한 것이지만, (1, 3)을 선택하는 것이 선택지가 많아짐.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 회의 개수
        int[][] meetings = new int[N][2]; // 회의 정보
        
        for(int i = 0; i < N; i++) {
            meetings[i][0] = scan.nextInt();
            meetings[i][1] = scan.nextInt();
        }
        scan.close();
        
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] b1) {
                if(a1[1] == b1[1]) {
                    return a1[0] - b1[0];
                }
                
                return a1[1] - b1[1];
            }
        });
        
        int count = 0;
        int lastEndTime = 0;
        
        for(int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            
            if(start >= lastEndTime) {
                lastEndTime = end;
                count ++;
            }
        }
        
        System.out.println(count);
    }
    
}