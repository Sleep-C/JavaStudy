package LeetcodeAll.week279;

import java.util.Arrays;

public class One效果不错_看看好的解答 {
    public static void main(String[] args) {
        sortEvenOdd(new int[]{4,1,2,3,3});
    }
    public static int[] sortEvenOdd(int[] nums) {
        String s = Arrays.toString(nums);
        if (nums.length <= 2){
            return nums;
        }
        int[] nums1 = new int[nums.length/2];//奇数
        int[] nums2 = new int[nums.length/2 + nums.length%2];
        for (int i = 1; i < nums.length; i+=2){
            nums2[i/2] = nums[i - 1];
            nums1[i/2] = nums[i];
        }
        if (nums.length%2 == 1){
            nums2[nums.length/2] = nums[nums.length - 1];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++){
            nums[2*i + 1] = nums1[nums1.length - i - 1];
        }
        for (int i = 0; i < nums2.length; i++){
            nums[2*i] = nums2[i];
        }
        return nums;
    }
//    public static void sort(int label, int left, int right){
//        int mid = left + label;
//        int l = left + 2;
//        int r = right;
//        //由递归的起始位置判断奇偶
////        if (l%2 == 0 && r%2 == 1){
////
////        }
////        if (l%2 == 1 && r%2 == 0){
////
////        }
//        while (l < r){
//
//        }
//    }
}
