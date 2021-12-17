package LeetcodeAll.doubleWeek67;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NintyNine20 {
    public static void main(String[] args) {
        System.out.println(maxSubsequence(new int[]{2,1,3,3},2));
    }
    public static int[] maxSubsequence(int[] nums, int k) {
        int[] nums_copy = nums.clone();
        int[] label = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            label[i] = i;
        }
        for (int i = 0; i < k; i++){
            for (int j = nums.length - 1; j > i ; j--){
                if (nums[j] > nums[j-1]){
                    int x = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = x;
                    x = label[j];
                    label[j] = label[j - 1];
                    label[j - 1] = x;
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k; i++){
            set.add(label[i]);
        }
        int[] out = new int[k];
        int m = 0;
        for (int i = 0; i < nums.length; i++){
             if (set.contains(i)){
                 out[m] = nums_copy[i];
                 m++;
             }
        }
        return out;
    }
}
