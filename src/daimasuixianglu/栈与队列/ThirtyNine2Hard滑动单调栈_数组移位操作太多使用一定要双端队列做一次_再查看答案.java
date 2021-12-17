package daimasuixianglu.栈与队列;

public class ThirtyNine2Hard滑动单调栈_数组移位操作太多使用一定要双端队列做一次_再查看答案 {
    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{9,11},2));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //两边开口的递减单调栈，
        if (k == 1){
            return nums;
        }
        int left = 0;
        int right = k - 1;
        int[] stack = new int[k];
        int top = 0;
        int[] out = new int[nums.length - (k - 1)];
        stack[top] = 0;
        for (int i = 1; i < k; i++){
            for (;top >= 0 && nums[stack[top]] <= nums[i];){
                top--;
            }
            top++;
            stack[top] = i;
        }

        for (;right < nums.length;){
            out[left] = nums[stack[0]];
            if (right == nums.length - 1){
                break;
            }
            if (left == stack[0]){
                for (int i = 0; i < top; i++){
                    stack[i] = stack[i + 1];
                }
                top--;
            }
            right++;
            if (nums[stack[top]] <= nums[right]){
                for ( ; top >= 0 && nums[stack[top]] <= nums[right];){
                    top--;
                }
                top++;
                stack[top] = right;
            }else {
                top++;
                stack[top] = right;
            }
            left++;
        }
        return out;
    }
}
