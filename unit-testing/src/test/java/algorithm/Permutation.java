package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
 
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>(); // 결과를 저장할 리스트
        
        int[] nums = {1, 2, 3}; // 순열을 구할 배열
        
        boolean[] used = new boolean[nums.length]; // 중복 사용 방지를 위한 배열
        List<Integer> currentPermutation = new ArrayList<>();
        
        // 순열 구하기
        permute2(nums, currentPermutation, used, result);
        
        // 결과 출력
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }
    
    private static void permute2(int[] nums, List<Integer> currentPermutation, boolean[] used, List<List<Integer>> result) {
        if(!currentPermutation.isEmpty()) {
            result.add(new ArrayList<>(currentPermutation)); // 추가
        }
        
        if(currentPermutation.size() == nums.length) { // 조합이 채워졌다면 종료
            return;
        }
        
        // 조합이 완료되지 않았을 경우
        for(int i = 0; i < nums.length; i++) {
            
            // 이미 추가된 경우
            if(used[i]) {
                continue;
            }
            
            used[i] = true; // 사용 표시
            currentPermutation.add(nums[i]); // 조합에 추가하기
            
            permute2(nums, currentPermutation, used, result); // 재귀 호출
            
            // 재귀 종료 후 상태 복원
            used[i] = false;
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }
    
    private static void permute1(int[] nums, List<Integer> currentPermutation, boolean[] used, List<List<Integer>> result) {
        // 조합이 완료되었을 경우 결과 리스트에 추가 후 종료
        if(currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }
        
        // 조합이 완료되지 않았을 경우
        for(int i = 0; i < nums.length; i++) {
            
            // 이미 추가된 경우
            if(used[i]) {
                continue;
            }
            
            used[i] = true; // 사용 표시
            currentPermutation.add(nums[i]); // 조합에 추가하기
            
            permute1(nums, currentPermutation, used, result); // 재귀 호출
            
            // 재귀 종료 후 상태 복원
            used[i] = false;
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }
}
