package algorithm;

public class MathUtil {

    // 최대 공약수
    public static int gcd(int num1, int num2) {
        // O(1), 상수 시간에 작동
        int big = Math.max(num1, num2);
        // O(1), 상수 시간에 작동
        int small = Math.min(num1, num2);

        // O(1), 상수 시간에 작동
        if (big < 0 || small < 0) {
            return -1;
        }

        int gcd = 0;

        // O(small), 루프는 small번 반복
        for (int i = 1; i <= small; i++) {
            if (big % i == 0 && (small % i) == 0) {
                gcd = i;
            }
        }

        // 전체 시간 복잡도 => O(small)
        return gcd;
    }

    // 최소 공배수
    public static int lcm(int num1, int num2) {
        // O(1), 상수 시간에 작동
        if (num1 == 0 || num2 == 0) {
            return 0;
        }

        // O(small), 루프는 small번 반복
        int gcd = gcd(num1, num2);
        // O(1), 상수 시간에 작동
        int lcm = (num1 * num2) / gcd;

        // 전체 시간 복잡도 => O(small)
        return Math.abs(lcm);
    }
}
