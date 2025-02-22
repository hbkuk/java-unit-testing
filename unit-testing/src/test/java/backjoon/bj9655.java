package backjoon;

import java.util.Scanner;

public class bj9655 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = Integer.parseInt(sc.nextLine());
        if(N % 2 != 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }

}
