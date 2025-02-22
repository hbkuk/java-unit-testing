package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class bj2607 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int C = scan.nextInt(); // 단어의 개수
        
        int[][] arr = new int[C][26];
        for (int i = 0; i < C; i++) {
            String word = scan.nextLine();
            
            char[] chars = word.toCharArray();
            for (char c : chars) {
                arr[i][c - 'A']++;
            }
        }
        scan.close();
        
        int 비슷한_단어_개수 = 0;
        
        for (int i = 1; i < C; i++) {
            int[] 기준_단어의_문자_개수 = Arrays.copyOf(arr[0], arr[0].length);
            boolean 비슷한_단어_여부 = true;
            
            int[] 비교할_단어의_문자_개수 = arr[i];
            for(int j = 0; j < 비교할_단어의_문자_개수.length; j++) {
                
                // 길이가 같으면서) 기준 단어와 비교할 단어가 하나만 다를 경우 => 비슷한 단어
                
                
                // 길이가 다를 경우) 기준 단어와 비교할 단어의 빈도 차이가 1일 경우 => 비슷한 단어

                
            }
            
            if(비슷한_단어_여부) {
                비슷한_단어_개수 ++;
            }
        }
        
        System.out.println(비슷한_단어_개수);
    }
    
}
