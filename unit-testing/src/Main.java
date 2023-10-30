import java.util.Scanner;

import static algorithm.RecursionUtil.factorial;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long result = factorial(N);
        System.out.println(result);
    }

}
