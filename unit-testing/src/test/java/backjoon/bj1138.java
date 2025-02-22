package backjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class bj1138 {
    
    /**
     * 맨 뒤부터 줄 세우기
     *
     * LinkedList로 세우기..
     * 중간에 결합을 끊고 맺고.. 하는 것을 유연하게 하기 위해서
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = Integer.parseInt(scan.nextLine()); // 사람의 수
        
        int[] person = new int[N + 1]; // 키가 1인 사람부터 N까지 ..
        for(int i = 1; i <= N; i++) {
            int count = scan.nextInt();
            person[i] = count;
        }
        
        LinkedList<Integer> list = new LinkedList<>();
        list.add(N); // 가장 큰 수 먼저 추가
        
        for(int i = N - 1; i > 0; i--) {
            int current = person[i]; // 현재 순번이 기억하는 왼쪽의 사람 수
            if(current == 0) { // 왼쪽에 아무도 없었던 경우
                list.addFirst(i);
            } else { // 왼쪽에 한명이라도 있었던 경우
                list.add(current, i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int el : list) {
            sb.append(el).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        
        System.out.println(sb);
    }
    
}
