package structure.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GraphExample {
    
//    public static void main(String[] args) {
//        int N = 5; // 노드 개수
//
//        // 그래프 생성: 노드 개수 +1 (1번부터 사용)
//        List<int[]>[] graph = new ArrayList[N + 1];
//
//        // 각 배열의 요소를 리스트로 초기화
//        for (int i = 1; i <= N; i++) {
//            graph[i] = new ArrayList<>();
//        }
//
//        // 그래프에 간선 추가 (출발, 도착, 시간, 비용)
//        graph[1].add(new int[]{2, 5, 10}); // 1 → 2 (시간 5, 비용 10)
//        graph[1].add(new int[]{3, 2, 4});  // 1 → 3 (시간 2, 비용 4)
//        graph[2].add(new int[]{4, 3, 6});  // 2 → 4 (시간 3, 비용 6)
//        graph[3].add(new int[]{4, 1, 2});  // 3 → 4 (시간 1, 비용 2)
//
//        // 그래프 출력
//        for (int i = 1; i <= N; i++) {
//            System.out.print("Node " + i + ": ");
//            for (int[] edge : graph[i]) {
//                System.out.print(Arrays.toString(edge) + " ");
//            }
//            System.out.println();
//        }
//    }


    public static void main(String[] args) {

        int N = 5; // 노드 개수

        // 그래프 생성
        List<int[]>[] graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[1].add(new int[]{2, 5, 10});  // 1번 노드 -> 2번 노드 (시간 5, 비용 10)
        graph[1].add(new int[]{3, 2, 4});   // 1번 노드 -> 3번 노드 (시간 2, 비용 4)
        graph[2].add(new int[]{4, 2, 3});   // 2번 노드 -> 4번 노드 (시간 2, 비용 3)

        for(int i = 1; i <= N; i++) {
            System.out.print("Node " + i + " : ");

            for(int[] edge : graph[i]) {
                System.out.print(Arrays.toString(edge) + " ");
            }
            System.out.println();
        }
    }
    
//    public static void main(String[] args) {
//
//        int N = 5; // 노드 개수
//
//        // 그래프 생성
//        List<Integer>[] graph = new ArrayList[N + 1];
//        Arrays.fill(graph, new ArrayList<>());
//
//        System.out.println(graph[0].size());
//        System.out.println(graph[1].size());
//        System.out.println(graph[2].size());
//        System.out.println(graph[3].size());
//        System.out.println(graph[4].size());
//
//        graph[0].add(1);
//        graph[0].add(2);
//        graph[0].add(3);
//
//        for(int value : graph[0]) {
//            System.out.println("value : " + value);
//        }
//    }
    
}
