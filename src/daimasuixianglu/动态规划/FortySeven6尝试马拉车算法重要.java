package daimasuixianglu.动态规划;

import java.util.ArrayList;
import java.util.List;

public class FortySeven6尝试马拉车算法重要 {
    public static void main(String[] args) {

    }
    //马拉车算法
    public static int countSubstrings(String s) {
        int mid = -1, right = -1;
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            sb.append('#');
        }
        sb.append('#');
        String new_s = sb.toString();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < sb.length(); i++){
            int len;
            if (right <= i){
                len = expand(new_s,i,i);
            }else{
                int left_len = Math.min(list.get(2*mid - i), right - i);
                len = expand(new_s,i - left_len, i + left_len);
            }
            list.add(len);
            if (i + len > right){
                right = i + len;
                mid = i;
            }
        }

        int result = s.length();
        // Iterator it = list.iterator();
        for (int i = 1; i < sb.length() - 1; i += 2){
            mid = list.get(i);
            result += mid/2;
            mid = list.get(i + 1);
            result += mid/2;
        }
        return result;
    }
    public static int expand(String sb,int left,int right){
        while(left >= 0 && right < sb.length() && sb.charAt(left) == sb.charAt(right)){
            left--;
            right++;
        }
        return (right - left - 2) / 2;
    }
    //https://www.jianshu.com/p/116aa58b7d81
    //中心扩散，
//    public static int countSubstrings(String s) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length() - 1; i++){
//            sb.append(s.charAt(i));
//            sb.append("#");
//        }
//        sb.append(s.charAt(s.length() - 1));
//        int[] manacher = new int[sb.length()];
//        int R = -1;
//        int C = -1;
//        for (int i = 0; i < sb.length(); i++){
//            if (R < i){
//
//            }else{
//
//            }
//        }
//        return 0;
//    }
}
