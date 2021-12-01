package LeetcodeAll;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



//我的思路，考虑以每一个i点的高作为矩形的高，向左右找第一个小于它的数。
public class EightyFourHard求比它小的反向单调栈 {
    //官方解答，从左往右遍历，使用单调栈，每次出栈，计算当前矩形值加抹去高于进栈元素的部分，
    //    public int largestRectangleArea(int[] heights) {
//        int n = heights.length;
//        int[] left = new int[n];
//        int[] right = new int[n];
//
//        Deque<Integer> mono_stack = new ArrayDeque<Integer>();
//        for (int i = 0; i < n; ++i) {
//            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
//                mono_stack.pop();
//            }
//            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
//            mono_stack.push(i);
//        }
//
//        mono_stack.clear();
//        for (int i = n - 1; i >= 0; --i) {
//            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
//                mono_stack.pop();
//            }
//            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
//            mono_stack.push(i);
//        }
//
//        int ans = 0;
//        for (int i = 0; i < n; ++i) {
//            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
//        }
//        return ans;
//    }
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,4}));
    }
    public static int largestRectangleArea(int[] heights) {
        int[] heights2 = heights.clone();
        int label;
        int num = heights2.length;
        for (int i = 0; i < num/2; i++){
            label = heights2[i];
            heights2[i] = heights2[num - i - 1];
            heights2[num - i - 1] = label;
        }
        int[] nums_right = nextGreaterElement(heights);
        int[] nums_left = nextGreaterElement(heights2);
        for (int i = 0; i < num; i++){
            if (nums_right[i] == -1 && nums_left[num - 1 - i] == -1){
                nums_right[i] = num;
            }else if (nums_right[i] == -1){
                nums_right[i] = nums_left[num - 1 - i];
            }else if (nums_left[num - 1 - i] == -1){
                nums_right[i] = nums_right[i];
            }else {
                nums_right[i] = nums_right[i] - (num - 1 - nums_left[num - 1 - i]) - 1;
            }
        }
        label = 0;
        for (int i = 0; i < num; i++){
            if (label < heights[i]*nums_right[i]){
                label = heights[i]*nums_right[i];
            }
        }
        return label;
    }
    public static int[] nextGreaterElement(int[] nums2) {
        int num = nums2.length;
        int[] nums1 = new int[num];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = num - 1; i >= 0;i--){
            for (; deque.peek() != null;){
                if (nums2[deque.peek()] >= nums2[i]){
                    deque.poll();
                }else {
                    nums1[i] = deque.peek();
                    deque.addFirst(i);
                    break;
                }
            }
            if (deque.peek() == null){
                deque.addFirst(i);
                nums1[i] = -1;
            }
        }
        return nums1;
    }
}
