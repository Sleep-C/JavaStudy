package daimasuixianglu.动态规划;

public class Fifteen1Hard双字符串的动态规划 {
    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag","bag"));
    }
    public static int numDistinct(String s, String t) {
        int[][] res = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++){
            res[i][0] = 1;
        }
        for (int i = 1; i < t.length() + 1; i++){
            for (int j = 1; j < s.length() + 1; j++){
                if (s.charAt(j - 1) == t.charAt(i - 1)){
                    res[j][i] = res[j - 1][i - 1] + res[j - 1][i];
                }else{
                    res[j][i] = res[j - 1][i];
                }
            }
        }
        return res[s.length()][t.length()];
    }
}
