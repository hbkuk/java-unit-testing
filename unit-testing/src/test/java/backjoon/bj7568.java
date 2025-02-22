package backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj7568 {
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        
        int[][] people = new int[N][3];
        for (int i = 0; i < N; i++) {
            people[i][0] = i;
            
            people[i][1] = scan.nextInt(); // 몸무게
            people[i][2] = scan.nextInt(); // 키
        }
        
        Arrays.sort(people, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[2], o1[2]); // 우선 키 순서대로
            };
        });
        
        int[][] rank = new int[N][2];
        
        rank[0][0] = people[0][0]; // 순서 저장
        rank[0][1] = 1; // 순위 저장
        for(int i = 1; i <people.length; i++) {
            
            // 앞에 순번보다 키가 크거나 몸무게가 크다면 => 동일한 순위
            if(people[i - 1][1] <= people[i][1]) {
                rank[i][0] = people[i][0];
                rank[i][1] = rank[i - 1][1];
                
            // 앞에 순번이 키와 몸무게가 크다면 => 현재 i + 1를 순위로
            } else {
                rank[i][0] = people[i][0];
                rank[i][1] = i + 1;
            }
        }
        
        Arrays.sort(rank, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]); // 순번 대로
            };
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < rank.length; i++) {
            sb.append(rank[i][1]).append(" ");
        }
        
        System.out.println(sb);
    }
}
