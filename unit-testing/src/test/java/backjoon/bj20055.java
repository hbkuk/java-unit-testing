package backjoon;

import java.util.Scanner;

public class bj20055 {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt(); // 내리는 위치
        int K = scan.nextInt(); // 종료되는 내구도 수
        
        int totalSize = N * 2;
        
        int[] numbers = new int[totalSize]; // 내구도 목록
        for (int i = 0; i < totalSize; i++) {
            numbers[i] = scan.nextInt();
        }
        
        scan.close();
        
        boolean[] robots = new boolean[totalSize]; // 로봇 위치
        
        int startIndex = 0; // 윗면의 가장 처음
        int endIndex = (numbers.length / 2) - 1; // 윗면의 가장 뒤
        
        int stepCount = 0;
        while (true) {
            stepCount++;
            
            // 컨베이어 벨트 이동
            int lastNumber = numbers[totalSize - 1];
            boolean lastRobot = robots[totalSize - 1];
            
            for (int i = 1; i <= totalSize - 1; i++) {
                numbers[i] = numbers[i - 1];
            }
            numbers[0] = lastNumber;
            
            for (int i = 1; i <= totalSize - 1; i++) {
                robots[i] = robots[i - 1];
            }
            robots[0] = lastRobot;
            
            // 만약 내리는 위치에 로봇이 있는 경우.. 내리기
            if (robots[endIndex]) {
                robots[endIndex] = false;
            }
            
            if (numbers[startIndex] > 0) {
                robots[startIndex] = true;
                numbers[startIndex] --;
            }
            
            for (int i = endIndex - 1; i >= startIndex; i--) {
                
                int 앞_내구도 = numbers[i + 1];
                boolean 앞_로봇_유무 = robots[i + 1];
                
                // 이동할 수 있는 경우
                if (앞_내구도 > 0 && !앞_로봇_유무) {
                    robots[i] = false;
                    robots[i + 1] = true;
                    numbers[i + 1] --;
                    
                    // 내리는 위치인 경우, 즉시 내리기
                    if (i + 1 == endIndex) {
                        robots[i] = false;
                    }
                }
            }
            
            // TODO 4: 내구도가 0인 칸이 K개 이상일 경우 종료
            int count = 0;
            for (int num : numbers) {
                if (num == 0) {
                    count++;
                }
            }
            
            if (count == K) {
                break;
            }
        }
        
        System.out.println(stepCount);
    }
}
