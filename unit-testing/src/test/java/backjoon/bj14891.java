package backjoon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class bj14891 {
    
    public static void main(String[] args) {
    
        // TODO 입력 받기
        //  - 톱니 관리: Deque
        //      - 맨 앞, 맨 뒤 추가 및 삭제 가능
        Scanner scan = new Scanner(System.in);
        
        List<Deque<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            Deque<Integer> queue = new ArrayDeque<>();
            
            String[] numbers = scan.nextLine().split("");
            for(String number : numbers) {
                int n = Integer.parseInt(number);
                queue.offer(n);
            }
            
            list.add(queue);
        }
        
        // TODO 동작 원리
        //  - 시계 방향으로 돈다?
        //      - 가장 앞 요소를 빼서, 맨 뒤로 넣는다.
        //  - 반시계 방향으로 돈다?
        //      - 맨 뒤 요소를 빼서, 가장 앞으로 넣는다.
        //  - 1번-2번 톱니 관계
        //      - 1번 index 2 <-> 2번 index 6
        //  - 2번-3번 톱니 관계
        //      - 2번 index 2 <-> 3번 index 6
        //  - 3번-4번 톱니 관계
        //      - 3번 index 2 <-> 4번 index 6
        int 시계_방향 = 1;
        int 반시계_방향 = -1;
        
        int K = scan.nextInt(); // 회전 횟수
        for(int i = 0; i < K; i++) {
            int 톱니바퀴_번호 = scan.nextInt() - 1;
            int 회전_방향 = scan.nextInt();
            
            Deque<Integer> queue = list.get(톱니바퀴_번호);
            if(회전_방향 == 시계_방향) {
                int 맨_처음_요소 = queue.pollFirst();
                queue.offerLast(맨_처음_요소);
            } else {
                int 맨_마지막_요소 = queue.pollLast();
                queue.offerFirst(맨_마지막_요소);
            }
            
            
            // 현재 톱니바퀴 기준으로 왼쪽 전파..
            for(int k = 톱니바퀴_번호 - 1; k >= 0; k--) {
                Deque<Integer> 전파될_톱니바퀴 = list.get(k);
                Deque<Integer> 이전_톱니바퀴 = list.get(k + 1);
                
                // 현재 2번과 이전 index 6번 확인
                int 현재_2번 = 0;
                int idx_2 = 0;
                for(int el : 전파될_톱니바퀴) {
                    if(idx_2 == 2) {
                        현재_2번 = el;
                    }
                    idx_2 ++;
                }
                
                int 이전_6번 = 0;
                int idx_6 = 0;
                for(int el : 이전_톱니바퀴) {
                    if(idx_6 == 6) {
                        이전_6번 = el;
                    }
                    idx_6 ++;
                }
                
                if(이전_6번 != 현재_2번) {
                    // ... TODO 이전에 어떻게 회전했는지 정보를 알아야하는데?
                }
            }
            
            // 현재 톱니비퀴 기준으로 오른쪽 전파ㅣ
        }
    }

}