package algorithm;

public class Greedy {

    /**
     * 전달된 distance에 도달하기 위해서 최소한의 배터리를 사용
     *
     * 조건식
     * 1) 순간이동을 할 수 있느냐
     * 2) 한칸 이동
     *
     * @param distance
     * @return
     */
    public static int battery(int distance) {
        int battery = 0;

        while (distance > 0) {
            if (distance % 2 == 0) {
                distance /= 2;
            } else {
                distance--;
                battery++;
            }
        }

        return battery;
    }
}
