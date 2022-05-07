package daimasuixianglu.动态规划;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{57,44,92,28,66,60,37,33,52,38,29,76,8,75,22},18));
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k < 2){
            return 0;
        }
        int result = 0;
        int n = 1;
        int i = 0;
        int j = 0;
        while (j < nums.length){
            while(i < nums.length && n < k){
                n = n*nums[i];
                i++;
            }
            if (i > 0 && n >= k){
                i--;
                n = n/nums[i];
            }

            result += (i - j);
            if (i != j){
                n = n/nums[j];
            }
            j++;
            if (j > i){
                i = j;
            }
        }
        return result;
    }

}
