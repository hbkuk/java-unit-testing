package 항해99;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TapAlgorithm {
    
    
    /**
     * 물통 옮기기
     * N개의 물통이 일렬로 놓여 있으며, 각각의 물통에는 일정한 양의 물이 담겨 있습니다. 철수는 이 물들을 모두 옮겨 물통을 비우려고 합니다. 그는 물을 옮길 때 다음과 같은 작업을 수행할 수 있습니다:
     *
     * 인접한 두 물통에서 동일한 양의 물을 퍼내거나 이동합니다.
     *
     * 한 물통에서 원하는 양의 물을 퍼내거나 이동합니다.
     *
     * 철수는 위 두 작업을 반복하여 모든 물통을 비우는 최소 작업 횟수를 계산하려고 합니다.
     *
     * 각 작업은 한 번의 물 옮기기로 계산됩니다.
     *
     * 문제 조건
     * 물통이 비워질 때까지 반복 작업을 수행해야 합니다.
     *
     * 물통에 물이 남아 있지 않아야 작업이 완료됩니다.
     *
     * 철수는 최소 작업 횟수를 목표로 해야 합니다.
     *
     * 입력 형식
     * 첫 번째 줄에 물통의 개수 N이 주어진다. (2 ≤ N ≤ 2,500)
     *
     * 두 번째 줄에 N개의 정수로 각 물통에 담긴 물의 양이 공백으로 구분되어 주어진다. (1≤물의 양≤108)
     *
     * 출력 형식
     * 철수가 모든 물통을 비우는 데 필요한 최소 작업 횟수를 출력한다.
     *
     * 예제 입력 1
     * 2
     * 1 2
     * 예제 출력 1
     * 2
     * 예제 입력 2
     * 4
     * 1 1 3 3
     * 예제 출력 2
     * 2
     * 예제 입력 3
     * 3
     * 1 4 3
     * 예제 출력 3
     * 2
     * 예제 입력 4
     * 5
     * 2 3 6 10 5
     * 예제 출력 4
     * 4
     */
    @Test
    void 물통_옮기기_테스트() {
        assertEquals(2, 물통_옮기기(2, new int[]{1, 2}));
        assertEquals(2, 물통_옮기기(4, new int[]{1, 1, 3, 3}));
        assertEquals(2, 물통_옮기기(3, new int[]{1, 4, 3}));
        assertEquals(4, 물통_옮기기(5, new int[]{2, 3, 6, 10, 5}));
    }
    
    private int 물통_옮기기(int N, int[] waters) {
        int operation = 0;
        int currentIndex = 0;
        
        while(currentIndex < N) {
            // 현재 인덱스의 물통이 0보다 큰지 확인
            if(waters[currentIndex] > 0) {
                int 퍼낼_물의_양 = waters[currentIndex];
                
                if(currentIndex + 1 <= N - 1) {
                    waters[currentIndex + 1] -= 퍼낼_물의_양;
                    
                }
                operation ++; // 무조건 일을 했다고 가정하기
            }
            currentIndex ++; // 무조건 동작을 진행한 후 이동
        }
        
        return operation;
    }
}
