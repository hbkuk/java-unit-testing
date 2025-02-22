package backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj2304_2 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 기둥의 개수
        int[][] posts = new int[N][2]; // 기둥 목록(왼쪽 면의 위치, 높이)
        
        for(int i = 0; i < N; i++) {
            posts[i][0] = scan.nextInt();
            posts[i][1] = scan.nextInt();
            scan.nextLine();
        }
        
        scan.close();
        
        Arrays.sort(posts, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        int centerIndex = 0;
        int maxHeight = 0;
        for(int i = 0; i < posts.length; i++) {
            int currentHeight = posts[i][1];
            if(currentHeight > maxHeight ) {
                centerIndex = i;
                maxHeight = currentHeight;
            }
        }
        
        int leftArea = 0;
        int leftMaxHeight = 0;
        for(int i = 1; i < centerIndex; i++) {
            int currentHeight = posts[i][1];
            
            int width = posts[i][0] - posts[i - 1][0];
            if(currentHeight > leftMaxHeight) {
                leftMaxHeight = currentHeight;
                leftArea += leftMaxHeight * width;
            } else {
                leftArea += leftMaxHeight * width;
            }
        }
        
        int rightArea = 0;
        int rightMaxHeight = posts[N - 1][1];
        for(int i = N - 2; i >= centerIndex + 1; i--) {
            int currentHeight = posts[i][1];
            
            int width = posts[i][0] - posts[i - 1][0];
            if(currentHeight > rightMaxHeight) {
                rightMaxHeight = currentHeight;
                rightArea += leftMaxHeight * width;
            } else {
                rightArea += leftMaxHeight * width;
            }
        }
        
        int 총_면적 = leftArea + rightArea + posts[centerIndex][1];
        
        System.out.println(총_면적);
    }
    
}
