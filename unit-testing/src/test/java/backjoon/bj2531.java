package backjoon;

import java.util.Scanner;

public class bj2531 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 회전 초밥 벨트에 놓인 접시의 수
        int d = scan.nextInt(); // 초밥의 가짓수
        int k = scan.nextInt(); // 연속해서 먹는 접시의 수
        int c = scan.nextInt(); // 쿠폰 번호
        
        int[] susi = new int[N];
        for (int i = 0; i < N; i++) {
            susi[i] = scan.nextInt();
        }
        
        findMaxVariety(N, d, k, c, susi);
    }
    
    private static void findMaxVariety(int N, int d, int k, int c, int[] susi) {
        int[] count = new int[d + 1];
        int variety = 0;
        
        // 초기 슬라이딩 윈도우 설정
        for (int i = 0; i < k; i++) {
            if (count[susi[i]] == 0) variety++;  // 현재 초밥이 처음 등장하면 종류 개수 추가
            count[susi[i]]++;                    // 해당 초밥 종류의 개수 증가
        }
        
        // 쿠폰 초밥 추가 고려
        int maxVariety = variety + (count[c] == 0 ? 1 : 0);
        
        // 슬라이딩 윈도우 이동
        for(int i = 1; i < N; i++) {
            int removeIndex = i - 1; // 윈도우에서 빠질 인덱스
            int addIndex = (i + k - 1) % N; // 윈도우에 새로 추가될 초밥 인덱스
            
            // 윈도우에서 초밥 제거
            if(count[susi[removeIndex]] == 1) {
                variety --;
            }
            count[susi[removeIndex]] --;
            
            // 윈도우에서 초밥 추가
            if(count[susi[addIndex]] == 0) {
                variety ++;
            }
            count[susi[addIndex]] ++;
            
            // 쿠폰 초밥 종류 포함 여부 확인
            if(count[c] == 0) {
                variety ++;
            }
        }
    }
    
}
