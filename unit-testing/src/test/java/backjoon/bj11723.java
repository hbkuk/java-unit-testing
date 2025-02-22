package backjoon;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class bj11723 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int M = Integer.parseInt(scanner.nextLine());
        
        Set<Integer> set = new HashSet<>();
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            
            operation(scanner.nextLine(), set, sb);
        }
    }
    
    public static void operation(String str, Set<Integer> set, StringBuilder sb) {
        String[] arr = str.split(" ");
        
        if(arr[0].startsWith("add")) {
            set.add(Integer.parseInt(arr[1]));
        }
        if(arr[0].startsWith("remove")) {
            set.remove(Integer.parseInt(arr[1]));
        
        }
        if(arr[0].startsWith("check")) {
            int number = Integer.parseInt(arr[1]);
            if(set.contains(number)) {
                sb.append(1);
            } else {
                sb.append(0);
            }
        
        }
        if(arr[0].startsWith("toggle")) {
            int number = Integer.parseInt(arr[1]);
            if(set.contains(number)) {
                set.remove(number);
            } else {
                set.add(number);
            }
        
        }
        if(arr[0].startsWith("all")) {
            set.clear();
            for(int i = 0; i < 20; i++) {
                set.add(i + 1);
            }
        }
        if(arr[0].startsWith("empty")) {
            set.clear();
        }
        
    }
}
