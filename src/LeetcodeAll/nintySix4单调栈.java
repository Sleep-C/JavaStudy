package LeetcodeAll;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class nintySix4单调栈 {
    public static void main(String[] args) {

    }
    /////单调栈O（m+n），倒着看，考虑哪些部分是以后不用的直接丢掉。。与我原始思路一致
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = nums2.length - 1; i >= 0; --i) {
            int num = nums2[i];
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            map.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

//    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        Map<Integer,Integer> map = new HashMap();
//        map.put(nums2[nums2.length-1],-1);
//        int label = 0;
//        for (int i = nums2.length - 2; i >= 0; i--){
//            if (nums2[i] < nums2[i+1]){
//                map.put(nums2[i],i + 1);
//            }else {
//                label = map.get(nums2[i + 1]);
//                for (;label != -1;){
//                    if (nums2[i] < nums2[label]){
//                        break;
//                    }
//                    label = map.get(nums2[label]);
//                }
//                if (label != -1){
//                    map.put(nums2[i],label);
//                }else {
//                    map.put(nums2[i],-1);
//                }
//            }
//        }
//        for (int i = 0; i<nums1.length; i++){
//            if (map.get(nums1[i]) != -1){
//                nums1[i] = nums2[map.get(nums1[i])];
//            }else {
//                nums1[i] = -1;
//            }
//
//        }
//        return nums1;
//    }
}
