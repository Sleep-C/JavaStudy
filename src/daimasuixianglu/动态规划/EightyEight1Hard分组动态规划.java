package daimasuixianglu.动态规划;

public class EightyEight1Hard分组动态规划 {
    public static void main(String[] args) {

    }
    //将每一天分为今天手上没有股票与今天手上有股票两种情况来考虑
    //参考123的答案解析理解
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length < 2){
            return 0;
        }
        int[][][] dp = new int[k + 1][2][prices.length + 1];
        int result = 0;
        for (int r = 1; r <= k; r++){
            dp[r][0][2*r - 1] = dp[r - 1][1][2*r - 2] - prices[2*r - 2];
            for (int i = 2*r; i <= prices.length; i++){
                dp[r][0][i] = Math.max(dp[r][0][i - 1],dp[r - 1][1][i - 1] - prices[i - 1]);
            }
            if (2*r - 1 >= prices.length){
                break;
            }
            dp[r][1][2*r] = dp[r][0][2*r - 1] + prices[2*r - 1];
            if (result < dp[r][1][2*r]){
                result = dp[r][1][2*r];
            }
            for (int i = 2*r + 1; i <= prices.length; i++){
                dp[r][1][i] = Math.max(dp[r][1][i - 1], dp[r][0][i - 1] + prices[i - 1]);
                if (result < dp[r][1][i]){
                    result = dp[r][1][i];
                }
            }
        }
        return result;
    }
}
