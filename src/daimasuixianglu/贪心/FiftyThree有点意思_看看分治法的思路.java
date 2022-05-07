package daimasuixianglu.贪心;

import java.util.*;

public class FiftyThree有点意思_看看分治法的思路 {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.isEmpty();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.pop();
        stack.isEmpty();
    }
    //重点在于对于负数/全负数组的处理
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int mid = 0;
        for (int i = 0; i < nums.length; i++){
            mid += nums[i];
            if (result < mid){
                result = mid;
            }
            if (mid < 0){
                mid = 0;
            }
        }
        return result;
    }
}
