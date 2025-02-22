package backjoon;

import java.util.*;

public class bj12763 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 건물의 개수
        
        int T = scan.nextInt(); // 수업 출석까지 남은 시간(해당 시간 이내 도착)
        int M = scan.nextInt(); // 현재 가지고 있는 돈
        
        int L = scan.nextInt(); // 노트에 적힌 정보
        
        List<int[]>[] graph = new ArrayList[N + 1];
        Arrays.fill(graph, new ArrayList<>());
        
        for(int i = 0; i < L; i++) {
            int sN = scan.nextInt();    // 시작 노드
            int eN = scan.nextInt();    // 도착 노드
            int time = scan.nextInt();  // 소요 시간
            int price = scan.nextInt(); // 가격
            
            graph[sN].add(new int[]{eN, time, price});  // 정방향 추가
            graph[eN].add(new int[]{sN, time, price});  // 역방향 추가
            
            System.out.println(graph[sN].size());
            System.out.println(graph[eN].size());
        }
    }
    
}
