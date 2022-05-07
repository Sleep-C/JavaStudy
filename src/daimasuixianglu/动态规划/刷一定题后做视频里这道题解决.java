package daimasuixianglu.动态规划;

public class 刷一定题后做视频里这道题解决 {
    //https://www.bilibili.com/video/BV1oY411V7ny
    //分类讨论
    public static void main(String[] args) {
        System.out.println(nearestPalindromic("1000001"));
    }
    public static String nearestPalindromic(String n) {
        if (n.length() == 1){
            return ((int)n.charAt(0) - (int)('1')) + "";//这里应该是n - 1
        }
        StringBuilder sb = new StringBuilder(n);
        int label = 0;
        for (int i = 0; i < n.length()/2; i++){
            if (sb.charAt(i) != sb.charAt(n.length() - i - 1)){
                label = 1;
                sb.setCharAt(n.length() - i - 1,sb.charAt(i));
            }
        }
        if (label == 0){
            int i = n.length()/2 - 1 + n.length()%2;
            while (sb.charAt(i) == '0'){
                i--;
            }
            if (i == 0 && sb.charAt(i) == '1'){
                sb = new StringBuilder();
                for (int k = 0; k < n.length() - 1; k++){
                    sb.append('9');
                }
            }else {
                sb.setCharAt(i,String.valueOf((int)sb.charAt(i) - (int)('1')).toCharArray()[0]);
                sb.setCharAt(n.length() - i - 1,String.valueOf((int)sb.charAt(i) - (int)('1')).toCharArray()[0]);
                i++;
                for (; i <= n.length()/2 - 1 + n.length()%2; i++){
                    sb.setCharAt(i, '9' );
                    sb.setCharAt(n.length() - i - 1, '9');
                }
            }
        }
        return sb.toString();
    }
}