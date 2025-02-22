package backjoon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class bj14891_2 {
    
    static int 시계_방향 = 1;
    static int 반시계_방향 = -1;
    static int 정지 = 0;
    
    static int N극 = 0;
    static int S극 = 1;
    
    public static void main(String[] args) {
        
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
        
        int K = scan.nextInt(); // 회전 횟수
        
        for(int i = 0; i < K; i++) {
            int[] 톱니바퀴_회전_방향 = new int[4]; // 시계: 1 | 반시계: -1 | 정지: 0
            
            int 회전된_톱니바퀴 = scan.nextInt() - 1; 
            int 회전_방향 = scan.nextInt(); 
            
            톱니바퀴_회전_방향[회전된_톱니바퀴] = 회전_방향;
            
            Deque<Integer> queue = list.get(회전된_톱니바퀴);
            if(회전_방향 == 시계_방향) {
                int polled = queue.pollFirst();
                queue.offerLast(polled);
            } else if(회전_방향 == 반시계_방향) {
                int polled = queue.pollLast();
                queue.offerFirst(polled);
            }
            
            // 왼쪽 전파
            for(int k = 회전된_톱니바퀴 - 1; k >= 0; k--) {
                // 현재 톱니바퀴
                Deque<Integer> 현재_톱니바퀴 = list.get(k);
                int 현재_톱니_값 = getValueOfIndex(현재_톱니바퀴, 2);
                
                // 앞전 톱니바퀴
                Deque<Integer> 전_톱니바퀴 = list.get(k + 1);
                int 전_톱니_값 = getValueOfIndex(전_톱니바퀴, 6);
                
                // 비교.. for문?
                //  오 톱니가 이전에 돌았다면 .. 왼 톱니 확인 필요
                if(톱니바퀴_회전_방향[k + 1] != 0) {
                    
                    // 왼_톱니_값과 오_톱니 값이 다를 경우.. 회전
                    if(현재_톱니_값 != 전_톱니_값) {
                        if(전_톱니_값 == 시계_방향) {
                            회전하기(현재_톱니바퀴, 반시계_방향);
                            톱니바퀴_회전_방향[k] = 반시계_방향;
                            
                        } else if (전_톱니_값 == 반시계_방향) {
                            회전하기(현재_톱니바퀴, 시계_방향);
                            톱니바퀴_회전_방향[k] = 시계_방향;
                        }
                    }
                }
            }
            
            // 오른쪽 전파
            for(int k = 회전된_톱니바퀴 + 1; k < 4; k++) {
                
                // 현재 톱니
                Deque<Integer> 현재_톱니바퀴 = list.get(k);
                int 현재_톱니_값 = getValueOfIndex(현재_톱니바퀴, 6);
                
                // 전 톱니
                Deque<Integer> 전_톱니바퀴 = list.get(k - 1);
                int 전_톱니_값 = getValueOfIndex(전_톱니바퀴, 2);
                
                // 비교 ... for문
                if(톱니바퀴_회전_방향[k - 1] != 0) {
                    
                    // 왼_톱니_값과 오_톱니 값이 다를 경우.. 회전
                    if(현재_톱니_값 != 전_톱니_값) {
                        if(전_톱니_값 == 시계_방향) {
                            회전하기(현재_톱니바퀴, 반시계_방향);
                            톱니바퀴_회전_방향[k] = 반시계_방향;
                            
                        } else if (전_톱니_값 == 반시계_방향) {
                            회전하기(현재_톱니바퀴, 시계_방향);
                            톱니바퀴_회전_방향[k] = 시계_방향;
                        }
                    }
                }
            }
        }
        
        int sum = 0;
        if(list.get(0).peekFirst() == S극) {
            sum += 1;
        }
        
        if(list.get(1).peekFirst() == S극) {
            sum += 2;
        }
        
        if(list.get(2).peekFirst() == S극) {
            sum += 4;
        }
        
        if(list.get(3).peekFirst() == S극) {
            sum += 8;
        }
        
        System.out.println(sum);
    }
    
    public static int getValueOfIndex(Deque<Integer> queue, int index) {
        int currentIndex = 0;
        
        for(int ele : queue) {
            if(currentIndex == index) {
                return ele;
            } else {
                currentIndex++;
            }
        }
        
        return 0;
    }
    
    public static void 회전하기(Deque<Integer> queue, int 회전_방향) {
        if(회전_방향 == 시계_방향) {
            int polled = queue.pollFirst();
            queue.offerLast(polled);
        } else if(회전_방향 == 반시계_방향) {
            int polled = queue.pollLast();
            queue.offerFirst(polled);
        }
    }

}