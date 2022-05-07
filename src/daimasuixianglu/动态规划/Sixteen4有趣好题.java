package daimasuixianglu.动态规划;

public class Sixteen4有趣好题 {
    public static void main(String[] args) {

    }
    //类似题目473，698
    //优化：将int数组换为boolean数组，用y/n作为可达性，逻辑或简化判断操作，同时boolean内存占用更小
    //官方解答也快不到哪里去，时间是最快解答的10倍
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
    //最快速解答，深度遍历
//    public boolean canPartition(int[] nums) {
//        if (nums.length <= 1) {
//            return false;
//        }
//        int sum = 0;
//        for (int num : nums) {
//            sum += num;
//        }
//        // 不是2的倍数，肯定不能分成2半
//        if (sum % 2 != 0) {
//            return false;
//        }
//        memo = new int[sum + 1];
//        return dfs(nums, 0, sum, 0);
//    }
//
//    int[] memo;
//
//    private boolean dfs(int[] nums, int curr, int sum, int index) {
//        // 表示当前值搜索过了
//        if (memo[curr] != 0) {
//            return memo[curr] == 1;
//        }
//        if (curr * 2 > sum) {
//            return false;
//        }
//        if (curr * 2 == sum) {
//            return true;
//        }
//        for (int i = index; i < nums.length; i++) {
//            if (dfs(nums, curr + nums[i], sum, i + 1)) {
//                memo[curr] = 1;
//                return true;
//            }
//        }
//        memo[curr] = -1;
//        return false;
//    }

    //我的解答
//    public boolean canPartition(int[] nums) {
//        if (nums.length == 1){
//            return false;
//        }
//        int num = 0;
//        for (int i = 0; i < nums.length; i++){
//            num += nums[i];
//        }
//        if (num%2 == 1){
//            return false;
//        }
//        num = num/2;
//        int[][] arr = new int[nums.length][num + 1];
//        for (int i = nums[0]; i < num + 1; i++){
//            arr[0][i] = nums[0];
//        }
//        for (int i = 1; i < nums.length; i++){
//            for (int j = 1; j < num + 1; j++){
//                int m = nums[i];
//                if (m > j){
//                    arr[i][j] = arr[i - 1][j];
//                }else{
//                    if (m + arr[i - 1][j - m] > arr[i - 1][j] && m + arr[i - 1][j - m] <= j){
//                        arr[i][j] = m + arr[i - 1][j - m];
//                    }else {
//                        arr[i][j] = arr[i - 1][j];
//                    }
//                }
//            }
//        }
//        if (arr[nums.length - 1][num] == num){
//            return true;
//        }else{
//            return false;
//        }
//    }
    //版本二
//    public boolean canPartition(int[] nums) {
//        if (nums.length == 1){
//            return false;
//        }
//        int num = 0;
//        int max = 0;
//        for (int i = 0; i < nums.length; i++){
//            num += nums[i];
//            if (max < nums[i]){
//                max = nums[i];
//            }
//        }
//        if (num%2 == 1){
//            return false;
//        }
//        num = num/2;
//        if (max > num){
//            return false;
//        }
//        boolean[][] arr = new boolean[nums.length][num + 1];
//        arr[0][nums[0]] = true;
//
//        for (int i = 0; i < nums.length; i++){
//            arr[i][0] = true;
//        }
//        for (int i = 1; i < nums.length; i++){
//            int m = nums[i];
//            for (int j = 1; j < num + 1; j++){
//                if (m > j){
//                    arr[i][j] = arr[i - 1][j];
//                }else{
//                    arr[i][j] = arr[i - 1][j] | arr[i - 1][j - m];
//                }
//            }
//        }
//        return arr[nums.length - 1][num];
//    }
}
