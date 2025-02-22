package backjoon;

import java.util.Scanner;

public class bj1244 {
    
    /**
     * 학생은 스위치 번호를 전달받아 번호에 따른 행동
     *
     * 남학생: 주어진 번호의 배수에 해당하는 스위치 번호에 상태 변경(토글)
     *  - ex) 3 -> 3, 6 스위치 상태 변경
     *
     * 여학생: 주어진 번호를 중심으로 좌우가 대칭이면서 && 가장 많은 스위치를 포함한 구간 내 스위치 상태 변경
     *
     * 예외 케이스
     *  1) 여학생 구간 탐색 시 범위 벗어남
     *  2) 주어진 스위치 숫자가 1일 경우
     *      - 남자) 1의 배수는... ? => 모든 수
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int switchLength = scan.nextInt();  // 스위치 개수
        
        boolean[] switchStatus = new boolean[switchLength]; // 스위치 상태(1: 켜짐, 0: 꺼짐)
        for(int i = 0; i < switchLength; i++) {
            switchStatus[i] = scan.nextInt() == 1;
        }
        
        int studentLength = scan.nextInt(); // 학생 수
        int[][] student = new int[studentLength][2]; //(0번 index: 1남자 2여자, 2번 index: 받은 스위치)
        for(int i = 0; i < studentLength; i++) {
            student[i][0] = scan.nextInt();
            student[i][1] = scan.nextInt();
        }
        
        // TODO student를 순회하면서, 시작...
        for(int i = 0; i < student.length; i++) {
            
            // 남자일 경우
            if(student[i][0] == 1) {
                // TODO: 받은 스위치 번호에 배수에 해당하는 스위치 상태 변경
                int switchNumber = student[i][1];
                
                for(int j = 0; j < switchLength; j++) {
                    // TODO 받은 스위치 번호로 스위치가 나누어 떨어질 경우 => 배수인경우
                    if((j + 1 ) % switchNumber == 0) {
                        switchStatus[j] = !switchStatus[j];
                    }
                }
            }
            
            // 여자일 경우
            else {
                // TODO: 받은 스위치를 중심으로 좌우 대칭구간 찾기
                
                int switchIdx = student[i][1] - 1; // 배열에서 사용하는 스위치 인덱스 번호
                
                int range = 0;
                
                while(true) {
                    int startIndex = switchIdx - 1 - range;
                    int endIndex = switchIdx + 1 + range;
                    
                    // 1) 범위 안에 있는 것은 맞지?
                    if(startIndex < 0 || endIndex > switchLength - 1) {
                        break;
                    }
                    
                    if(switchStatus[startIndex] == switchStatus[endIndex]) {
                        range++;
                    } else {
                        break;
                    }
                }
                
                
                // TODO 범위를 찾지 못했다면 중심만
                if(range == 0) {
                    switchStatus[switchIdx] = !switchStatus[switchIdx];
                } else {
                    for(int j = switchIdx - range; j <= switchIdx + range; j++) {
                        switchStatus[j] = !switchStatus[j];
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < switchStatus.length; i++) {
            if(switchStatus[i]) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
            
            if((i + 1) % 20 == 0) { // 20개씩 출력
                sb.append("\n");
            }
        }
        
        System.out.println(sb);
    }
    
}
