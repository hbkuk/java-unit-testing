package backjoon;

import java.util.Scanner;

public class bj4659 {
    
    /**
     * 1. 모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
     * 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
     * 3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        char[] requiredChar = new char[]{'a', 'e', 'i', 'o', 'u'};
        
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = scan.nextLine();
            
            // 종료조건
            if (line.equals("end")) {
                break;
            }
            
            char[] currentChars = line.toCharArray();
            
            boolean isContain = false;
            for (char cur : currentChars) {
                for (char r : requiredChar) {
                    if (cur == r) {
                        isContain = true;
                        break;
                    }
                }
                
                if(isContain) {
                    break;
                }
            }
            
            if (!isContain) {
                appendResult(sb, line, true);
                continue;
            }
            
            int sameCount = 1;
            for(int i = 1; i < currentChars.length; i++) {
                // 이전 글자가 모음인지?
                boolean isPrevM = false;
                for(char r : requiredChar) {
                    if(currentChars[i - 1] == r) {
                        isPrevM = true;
                        break;
                    }
                }
                
                // 현재 글자가 모음인지?
                boolean isCurM = false;
                for(char r : requiredChar) {
                    if(currentChars[i] == r) {
                        isCurM = true;
                        break;
                    }
                }
                
                // 이전 글자와 현재 글자가 같은지?
                // 모음 + 모음 => true
                // 자음 + 자음 => true
                // 모음 + 자음 => false
                if(isPrevM == isCurM) {
                    sameCount ++;
                } else {
                    sameCount = 1;
                }
                
                if(sameCount == 3) {
                    break;
                }
            }
            
            if(sameCount == 3) {
                appendResult(sb, line, true);
                continue;
            }
            
            
            // TODO 3) 같은 글자가 연속으로 오고 있냐?(단, ee와 oo는 허용)
            boolean isPrevCurSame = false;
            for(int i = 1; i < currentChars.length; i++) {
                if(currentChars[i - 1] == currentChars[i]) {
                    if(currentChars[i] != 'e' && currentChars[i] != 'o') {
                        isPrevCurSame = true;
                        break;
                    }
                }
            }
            
            appendResult(sb, line, isPrevCurSame);

        }
        
        System.out.println(sb);
    }
    
    public static void appendResult(StringBuilder sb, String line, boolean isNot) {
        sb.append("<").append(line).append(">").append(" ")
            .append("is").append(" ");
        if (isNot) {
            sb.append("not").append(" ");
            
        }
        sb.append("acceptable.").append("\n");
    }
}
