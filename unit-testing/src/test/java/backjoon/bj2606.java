package backjoon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class bj2606 {
    
    static int 감염된_컴퓨터_수 = 0;
    static boolean[] vistied;
    
    public static void main(String[] args) {
        // TODO 1: 입력받기
        Scanner scan = new Scanner(System.in);
        int C = Integer.parseInt(scan.nextLine()); // 컴퓨터 수
        int N = Integer.parseInt(scan.nextLine()); // 컴퓨터 쌍의 수
        
        // TODO: 연결 관리
        vistied = new boolean[C + 1];
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int start = scan.nextInt(); // 시작
            int end = scan.nextInt(); // 도착
            
            Queue<Integer> queue1 = map.get(start);
            if (queue1 == null) {
                queue1 = new LinkedList<>();
                map.put(start, queue1);
            }
            queue1.add(end);
            
            Queue<Integer> queue2 = map.get(end);
            if (queue2 == null) {
                queue2 = new LinkedList<>();
                map.put(end, queue2);
            }
            queue2.add(start);
            
        }
        
        // TODO 2: 1번 컴퓨터를 통해 웜 바이러스 진행
        //  - 감염된 컴퓨터 숫자만큼 Counting
        dfs(1, map);
        
        // TODO 3: 결과 출력 -> 컴퓨터 수 - 감염된 컴퓨터 숫자
        System.out.println(감염된_컴퓨터_수 - 1);
    }
    
    public static void dfs(int start, Map<Integer, Queue<Integer>> map) {
        if (vistied[start]) return;
        
        vistied[start] = true;
        감염된_컴퓨터_수++; // 현재 컴퓨터 감염표시
        
        // 연결된 컴퓨터 목록
        Queue<Integer> queue = map.get(start);
        
        // 연결된 컴퓨터 목록 감염시키기
        while (queue != null && !queue.isEmpty()) {
            int next = queue.poll();
            
            if(!vistied[next]) {
                dfs(next, map);
            }
        }
    }
    
}
