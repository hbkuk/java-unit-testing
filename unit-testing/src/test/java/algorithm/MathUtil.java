package algorithm;

public class MathUtil {

    // 최대 공약수
    public static int gcdLoop(int num1, int num2) {
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

    public static int gcdRecursion(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcdRecursion(num2, num1 % num2);
    }

    // 최소 공배수
    public static int lcm(int num1, int num2) {
        // O(1), 상수 시간에 작동
        if (num1 == 0 || num2 == 0) {
            return 0;
        }

        // O(small), 루프는 small번 반복
        int gcd = gcdLoop(num1, num2);
        // O(1), 상수 시간에 작동
        int lcm = (num1 * num2) / gcd;

        // 전체 시간 복잡도 => O(small)
        return Math.abs(lcm);
    }

    // 1. nCr => n! / r! * (n-r)!
    public static int basicCombination(int n, int r) {
        if (r > n || r < 0) {
            return 0;
        }

        // 최악: O(N) + O(N) + O(N) = O(N)
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    private static int factorial(int num) {
        if (num == 0) {
            return 1;
        }

        int result = 1;

        // O(N), 입력받은 num 만큼 루프 반복
        while (num > 0) {
            result *= num;
            num--;
        }
        return result;
    }

    public static int findPrimeNum(int number) {
        if (number < 0) {
            return -1;
        }

        if (number < 2) {
            return 0;
        }

        int primeCount = 0;
        for (int i = 2; i <= number; i++) { // Loop range ==> 1 ~ i
            boolean isPrime = true;

            // i... 이거 소수니?
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primeCount++;
            }
        }
        return primeCount;
    }

    public static int fibonacciByFor(int number) {
        int prePointer = 1;
        int prePrePointer = 0;
        int currentValue = 0;
        for (int i = 2; i <= number; i++) {
            currentValue = prePrePointer + prePointer;
            prePrePointer = prePointer;
            prePointer = currentValue;
        }
        return currentValue;
    }

    public static int fibonacciByRec(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return fibonacciByRec(number - 2) + fibonacciByRec(number - 1);
    }

    public static int fibonacciByDp(int number) {
        if (number < 0) {
            return -1;
        }

        int[] dp = new int[number + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= number; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[number];
    }

    public static int sumEachNumber(int value) {
        int base = Math.abs(value);
        int result = 0;

        while (base > 0) {
            result += base % 10;
            base = base / 10;
        }

        return result;
    }

    public static int ladder(int number) {
        if (number < 2) {
            return 1;
        }
        return ladder(number - 2) + ladder(number - 1);
    }

    public static int[] carpet(int brown, int yellow) {
        int area = brown + yellow;
        int[] answer = new int[2];

        for (int i = 3; i <= Math.sqrt(area); i++) {
            if (area % i == 0) {
                int width = area / i;
                int height = i;

                if ((width + height) * 2 - 4 == brown) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }
        return answer; // return {width, height}
    }

    public static long longJump(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 123456;
        }

        return dp[n];
    }
}
