package daimasuixianglu.贪心;

import java.util.PriorityQueue;

public class Five10 {
    public static void main(String[] args) {
        System.out.println(largestSumAfterKNegations(new int[]{-2,5,0,2,-2},3));
    }
    public static int largestSumAfterKNegations(int[] nums, int k) {
        int result = 0;
        int min = Math.abs(nums[0]);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++){
            result += nums[i];
            if (min > Math.abs(nums[i])){
                min = Math.abs(nums[i]);
            }
            if (nums[i] < 0){
                priorityQueue.add(nums[i]);
            }
        }
        while (priorityQueue.size() > 0 && k > 0){
            result += -2*priorityQueue.poll();
            k--;
        }
        if (k == 0 || k%2 == 0){
            return result;
        }
        return result - 2*min;
    }
}
