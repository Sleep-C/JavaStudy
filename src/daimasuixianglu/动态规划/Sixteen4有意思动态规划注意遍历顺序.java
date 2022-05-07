package daimasuixianglu.动态规划;

public class Sixteen4有意思动态规划注意遍历顺序 {
    public static void main(String[] args) {

    }
    public static int longestPalindromeSubseq(String s) {
        int result = 1;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++){
            dp[i][i] = 1;
        }
        for (int i = s.length() - 1; i >= 0; i--){
            for (int j = i + 1; j < s.length(); j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    if (result < dp[i][j]){
                        result = dp[i][j];
                    }
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return result;
    }
}
