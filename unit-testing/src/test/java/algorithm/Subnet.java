package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Subnet {
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; // 주어지는 배열
        
        int c = 2; // 선택할 개수
        
        List<List<Integer>> result = new ArrayList<>(); // 결과 담기
        List<Integer> currentCombination = new ArrayList<>(); // 현재 조합
        
        // 길이에 상관없이 모든 조합 구하기
        generateSubnet(nums, 0, result, currentCombination, c);
        
        // 결과 출력
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
    
    private static void generateSubnet(int[] nums, int start, List<List<Integer>> result, List<Integer> currentCombination, int count) {
        // count 만큼 조합이 완성되었을 경우  경우 리스트에 담기
        result.add(new ArrayList<>(currentCombination));
        
        for(int i = start; i < nums.length; i++) {
            currentCombination.add(nums[i]);
            generateSubnet(nums, i + 1, result, currentCombination, count);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
    
}
