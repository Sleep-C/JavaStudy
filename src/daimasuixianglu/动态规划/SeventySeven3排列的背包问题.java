package daimasuixianglu.动态规划;

import java.util.Arrays;

public class SeventySeven3排列的背包问题 {
    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1,2,3},4));
    }
    public static int combinationSum4(int[] nums, int target) {
        int[] res = new int[target + 1];
        res[0] = 1;
        for (int i = 1; i <= target; i++){
            for (int j = 0; j < nums.length; j++){
                int a = nums[j];
                if (a <= i){
                    res[i] += res[i - a];
                }
            }
        }
        return res[target];
    }
}
