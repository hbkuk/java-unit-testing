package backjoon;

import java.util.Scanner;

public class bj1406 {
    
    /**
     * 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 구하는 프로그램
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        char[] chars = scan.nextLine().toCharArray();
        
        int actionCount = Integer.parseInt(scan.nextLine());
        int cursorIndex = chars.length + 1; // 초기 커서 => 문장 맨 뒤 위치
        
        for(int i = 0; i < actionCount; i++) {
            // 명령 수행
            String action = scan.nextLine();
            
            char command = action.charAt(0);

            // 커서 왼쪽 한칸 옮김
            if(command == 'L') {
                
                // 커서가 맨 좌측이 아닐 경우 
                if(cursorIndex > 0) {
                    cursorIndex --;
                }
            }
            
            // 커서 오른쪽 한칸 옮김
            if(command == 'D') {
                
                // 커서가 맨 우측이 아닐 경우
                if(cursorIndex < chars.length + 1) {
                    cursorIndex ++;
                }
            }
            
            // 커서 왼쪽 문자 삭제
            if(command == 'B') {
                
                // 0번 인덱스일 경우 삭제 안함
                if(cursorIndex > 0) {
                    
                    char[] newChars = new char[chars.length - 1];
                    boolean isSkip = false;
                    for(int j = 0; j < newChars.length; j++) {
                        if(cursorIndex == j) {
                            isSkip = true;
                            continue;
                        }
                        
                        if(isSkip) {
                            newChars[j] = chars[j - 1];
                        } else {
                            newChars[j] = chars[j];
                        }

                    }
                    chars = newChars;
                    
                    cursorIndex --;
                }
            }
            
            if(command == 'P') {
                char word = action.charAt(1);
                
                char[] newChars = new char[chars.length + 1];
                for(int j = 0, offset = 0; j < chars.length; j++) {
                    if(cursorIndex == j) {
                        newChars[j] = word;
                        offset++;
                    } else {
                        newChars[j+offset] = chars[j];
                    }
                }
                
                chars = newChars;
                cursorIndex ++;
            }
            
        }
        
        System.out.println(new String(chars));
    }
    
}
