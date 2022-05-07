package daimasuixianglu.动态规划;

public class NinetyFour4 {
    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{7,9,3,8,0,2,4,8,3,9},0));
    }
    public static int findTargetSumWays(int[] nums, int target) {
        int all = 0;
        for (int i = 0; i < nums.length; i++){
            all += nums[i];
        }
        if (all < target){
            return 0;
        }
        if ((all - target)%2 == 1){
            return 0;
        }
        int tar = (all - target)/2;
        int[] arr = new int[tar + 1];
        arr[0] = 1;
        for (int i = 0; i < nums.length; i++){
            int m = nums[i];
            for (int j = tar; j >= 0; j--){
                if (j >= m){
                    arr[j] += arr[j - m];
                }
            }
        }
        return arr[tar];
    }
}
