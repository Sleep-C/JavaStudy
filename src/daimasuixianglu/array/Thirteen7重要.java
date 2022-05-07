package daimasuixianglu.array;

public class Thirteen7重要 {
    public static void main(String[] args) {

    }
    //官方滑动窗口，简洁明了
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, ret = 0;
        int prod = 1, i = 0;
        for (int j = 0; j < n; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k) {
                prod /= nums[i];
                i++;
            }
            ret += j - i + 1;
        }
        return ret;
    }
    //我的滑动窗口，，，修修补补，多次debug
//    public static int numSubarrayProductLessThanK(int[] nums, int k) {
//        if (k < 2){
//            return 0;
//        }
//        int result = 0;
//        int n = 1;
//        int i = 0;
//        int j = 0;
//        while (j < nums.length){
//            while(i < nums.length && n < k){
//                n = n*nums[i];
//                i++;
//            }
//            if (i > 0 && n >= k){
//                i--;
//                n = n/nums[i];
//            }
//
//            result += (i - j);
//            if (i != j){
//                n = n/nums[j];
//            }
//            j++;
//            if (j > i){
//                i = j;
//            }
//        }
//        return result;
//    }
}
