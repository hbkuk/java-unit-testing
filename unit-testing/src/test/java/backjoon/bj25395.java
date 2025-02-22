package backjoon;

import java.util.*;

public class bj25395 {
    
    static int N;
    static int S;
    
    static int[][] info;
    static boolean[] visited;
    
    static List<Integer> reachable;
    
    static int maxDistance;
    
    static int visitedLeft;
    static int visitedRight;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        N = scan.nextInt(); // 커넥티드 카 수량
        S = scan.nextInt(); // 먼저 연결된 커넥티드 카 번호
        
        info = new int[N + 1][2];
        visited = new boolean[N + 1];
        reachable = new ArrayList<>();
        
        // 위치 세팅
        for(int i = 1; i <= N; i++) {
            int value = scan.nextInt();
            info[i][0] = value;
            
            maxDistance = Math.max(maxDistance, value);
        }
        
        // 연료 세팅
        for(int i = 1; i <= N; i++) {
            info[i][1] = scan.nextInt();
        }
        
        scan.close();
        
        visitedLeft = info[S][1];
        visitedRight = info[S][1];
        
        visited[S] = true;
        reachable.add(S);
        dfs(S);
        
        
        Collections.sort(reachable);
        
        StringBuilder sb = new StringBuilder();
        for(int node : reachable) {
            sb.append(node)
                .append(" ");
        }
        
        System.out.println(sb);
    }
    
    public static void dfs(int start) {
        int maxLeft = Math.max(0, info[start][0] - info[start][1]);
        int maxRight = Math.min(maxDistance, info[start][0] + info[start][1]);
        
        // TODO: lp, rp 라는 것은 -> 다른 노드에서 이미 방문한 경우.. 해당 포인터까지 탐색을 완료했다는 것을 알려준다.. 이걸 어떻게 활용할 수 있을까?
        
        // 왼쪽 갈 수 있는지 확인
        for(int i = start - 1; i >= 1; i--) {
            
            // 도달할 수 없는 경우 즉시 종료
            if(info[i][0] < maxLeft) {
                break;
            }
            
            // 도달 가능 && 방문하지 않았으면 DFS
            else if(!visited[i]) {
                visited[i] = true;
                reachable.add(i);
                
                dfs(i);
            }
        }
        
        // 오른쪽 갈 수 있는지 확인
        for(int i = start + 1; i <= N; i++) {
            
            // 도달할 수 없는 경우 즉시 종료
            if(info[i][0] > maxRight) {
                break;
            }
            
            // 도달 가능 && 방문하지 않았으면 DFS
            else if(!visited[i]) {
                visited[i] = true;
                reachable.add(i);
                
                dfs(i);
            }
        }
    }
    
}

