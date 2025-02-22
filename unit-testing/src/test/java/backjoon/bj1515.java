package backjoon;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class bj1515 {
    
    /**
     * 이어 붙인 수가 주어질 때, N의 최솟값 출력하기
     * <p>
     * 1. Base(1부터 최대 N까지), Pointer(범위 0 ~ 9까지)
     * - Base는 1부터 계속 증가시키면서, Pointer와 비교
     * - Base는 잘게 쪼개서, 여러개의 Pointer에 소거될 수 있다.
     */
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        String line = scan.nextLine(); // 이어붙인 수
        
        int base = 0; // 1부터 N까지 증가시킬 수
        int currentIndex = 0; // 하나씩 비교할 포인터
        
        while (currentIndex <= line.length() - 1) {
            int currentValue = line.charAt(currentIndex) - '0'; // char -> int 변환
            
            String[] splited = String.valueOf(base).split("");
            List<String> list = Arrays.stream(splited).collect(Collectors.toList());
            
            if (base < 10) { // 아직 base가 일의 자리 숫자일 경우
                if (currentValue == base) { // 숫자를 찾은 경우
                    currentIndex++;
                    base++;
                } else { // 숫자를 못찾은 경우
                    base++;
                }
            } else { // 십의 자리 숫자 이상인 경우
                
                while (!list.isEmpty() && currentIndex <= line.length() - 1 && list.contains(String.valueOf(currentValue))) {
                    currentValue = line.charAt(currentIndex) - '0'; // char -> int 변환
                    
                    // 1. list에서 제거
                    list.remove(String.valueOf(currentValue));
                    
                    // 다음 인덱스까지 계속 확인, 단, 하나라도 다를 경우 즉시 종료
                    currentIndex++;
                }
                
                base++;
            }
        }
        System.out.println(base - 1);
    }
    
}
