package daimasuixianglu.其他重要算法;

import java.util.Deque;
import java.util.LinkedList;

public class aKMP未完成 {
    //滑动窗口239，无关,480有意思，未做
    //可能相关718
    //https://www.nowcoder.com/practice/bb1615c381cc4237919d1aa448083bcc?tpId=117&&tqId=37859&&companyId=239&rp=1&ru=/company/home/code/239&qru=/ta/job-code-high/question-ranking
    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{1,-1},1));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> stack = new LinkedList<>();
        int right = k;
        stack.add(nums[0]);
        for (int i = 1; i < k; i++){
            if (stack.peekLast() >= nums[i]){
                stack.add(nums[i]);
            }else{
                for (;stack.size() > 0 && stack.peekLast() < nums[i]; ){
                    stack.pollLast();
                }
                stack.add(nums[i]);
            }
        }
        result[0] = stack.peekFirst();
        for (; right < nums.length; right++){
            if (stack.peekFirst() == nums[right - k]){
                stack.pollFirst();
            }

            if (stack.peekLast() >= nums[right]){
                stack.add(nums[right]);
            }else{
                for (; stack.size() > 0 && stack.peekLast() < nums[right]; ){
                    stack.pollLast();
                }
                stack.add(nums[right]);
            }
            result[right - k + 1] = stack.peekFirst();
        }
        return result;
    }
}
