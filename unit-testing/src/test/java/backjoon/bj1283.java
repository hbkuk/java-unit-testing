package backjoon;

import java.util.Scanner;

public class bj1283 {
    
    /**
     * 단축키를 지정하는 법
     *
     * 1) 왼쪽에서부터 오른쪽 순서로 단어의 첫 글자가 이미 단축키로 지정되었는지?
     *  - true =>  2번으로 넘어감.
     *  - false => 해당 알파벳으로 지정
     *
     * 2) 왼쪽에서부터 차례대로 알파벳이 단축키로 지정되었는지?
     *  - true => 지정하지 않음.
     *  - false => 해당 알파벳으로 지정.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // 입력 받기
        int N = scan.nextInt(); // 옵션 수
        scan.nextLine();
        
        String[] options = new String[N]; // 옵션 원본
        for(int i = 0; i < N; i++) {
            options[i] = scan.nextLine();
        }
        
        String[] results = new String[N]; // 결과
        
        boolean[] isAssigned = new boolean[26];
        
        for(int i = 0; i < options.length; i++) {
            String originalOption = options[i]; // 원본 옵션
            
            String[] split = originalOption.split(" "); // 공백 기준 분리한 옵션 문자열
            boolean isAssign = false;
            
            // TODO 1번 단계 진행
            for(int j = 0; j < split.length; j++) {
                
                // 분리한 단어들의 첫문자 가져오기
                int first = split[j].toUpperCase().charAt(0) - 'A';
                
                // 이미 지정되어있지 않을 경우
                if(!isAssigned[first]) {
                    isAssigned[first] = true; // 배정
                    isAssign = true; // 배정
                    
                    StringBuilder assembled = new StringBuilder(); // 결과에 담을 단어 조합
                    for(int k = 0; k < split.length; k++) {
                        if(k != j) {
                            assembled.append(split[k]); // 단어 그대로 붙여주기
                        } else {
                            assembled
                                .append("[")
                                .append(split[j].charAt(0))
                                .append("]")
                                .append(split[k].substring(1));
                        }
                        
                        assembled.append(" ");
                    }
                    assembled.append("\n"); // 줄바꿈
                    results[i] = assembled.toString();
                    break;
                }
            }
            
            // 배정된 경우 다음 옵션 진행
            if(isAssign) {
                continue;
            }
            
            // TODO 2번 단계 진행
            for(int j = 0; j < split.length; j++) {
                for(int k = 0; k < split[j].length(); k++) {
                    int word = split[j].toUpperCase().charAt(k) - 'A'; // 분리한 단어의 특정 인덱스 문자
                    
                    // 지정되어 있지 않은 경우
                    if(!isAssigned[word]) {
                        isAssign = true; // 배정
                        isAssigned[word] = true; // 배정
                        
                        StringBuilder assembled = new StringBuilder(); // 결과에 담을 단어 조합
                        for(int z = 0; z < split.length; z++) {
                            
                            if(j != z) {
                                assembled.append(split[z]);
                            } else {
                                assembled.append(split[z].substring(0, k))
                                    .append("[")
                                    .append(split[z].charAt(k))
                                    .append("]")
                                    .append(split[z].substring(k + 1));
                            }
                            
                            assembled.append(" ");
                        }
                        
                        assembled.append("\n"); // 줄바꿈
                        results[i] = assembled.toString();
                        break;
                    }
                }
                if(isAssign) {
                    break;
                }
            }
            
            
            // 1번, 2번에서 배정되지 못한 경우, 그대로 사용 
            if(!isAssign) {
                results[i] = originalOption + "\n";
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        // TODO: 결과 출력
        for(String result : results) {
            sb.append(result);
        }
        
        System.out.println(sb);
    }
    
}
