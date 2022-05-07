package daimasuixianglu.动态规划;

import java.util.ArrayList;
import java.util.List;

public class SeventyFour4 {
    public static void main(String[] args) {

        System.out.println(findMaxForm(new String[]{"10","0001","111001","1","0"},5,3));
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] arr = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++){
            String s = strs[i];
            for (int j = 0; j < s.length(); j++){
                if (s.charAt(j) == '0'){
                    arr[i][0]++;
                }else {
                    arr[i][1]++;
                }
            }
        }
        int[][] result = new int[m + 1][n + 1];
        // result[0][0] = 0;
        for (int i = 0; i < strs.length; i++){
            int[] a = arr[i];
            for (int j = m; j >= a[0]; j--){
                for (int k = n; k >= a[1]; k--){
                    if (result[j][k] < result[j - a[0]][k - a[1]] + 1){
                        result[j][k] = result[j - a[0]][k - a[1]] + 1;
                    }

                }
            }
        }
        return result[m][n];
    }
}
