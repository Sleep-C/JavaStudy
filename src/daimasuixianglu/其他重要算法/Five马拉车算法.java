package daimasuixianglu.其他重要算法;

import java.util.ArrayList;
import java.util.List;

public class Five马拉车算法 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }
    //官方解答，非常巧妙
    public static String longestPalindrome(String s) {
        int start = 0, end = -1;
        StringBuffer t = new StringBuffer("#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        s = t.toString();

        List<Integer> arm_len = new ArrayList<Integer>();
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); ++i) {
            int cur_arm_len;
            if (right >= i) {
                int i_sym = j * 2 - i;
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = expand(s, i, i);
            }
            arm_len.add(cur_arm_len);
            if (i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }
            if (cur_arm_len * 2 + 1 > end - start) {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }

        StringBuffer ans = new StringBuffer();
        for (int i = start; i <= end; ++i) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }
    //我的解答
//    public static String longestPalindrome(String s) {
//        StringBuilder sb = new StringBuilder();
//        if (s.length() == 1){
//            return "s";
//        }
//        for (int i = 0; i < s.length() - 1; i++){
//            sb.append(s.charAt(i));
//            sb.append('#');
//        }
//        sb.append(s.charAt(s.length() - 1));
//        int[] arr = new int[sb.length()];
//        int right = -1;
//        int mid = -1;
//        for (int i = 0; i < sb.length(); i++){
//            if (i > right){
//                mid = i;
//                right = i;
//                for (int j = i + 1; j < sb.length(); j++){
//                    if (i - (j - i) < 0 || sb.charAt(j) != sb.charAt(i - (j - i))){
//                        break;
//                    }
//                    right = j;
//                    arr[i] = j - i;
//                }
//            }else if (i == right){
//                if (arr[mid*2 - right] == 0){
//                    for (int j = i + 1; j < sb.length(); j++){
//                        if (i - (j - i) < 0 || sb.charAt(j) != sb.charAt(i - (j - i))){
//                            break;
//                        }
//                        mid = i;
//                        right = j;
//                        arr[i] = j - i;
//                    }
//                }else {
//                    arr[i] = 0;
//                }
//            }else{
//                if (arr[2*mid - i] + i > right){
//                    arr[i] = right - i;
//                }else if (arr[2*mid - i] + i == right){
//                    mid = i;
//                    for (int j = right + 1; j < sb.length(); j++){
//                        if (i - (j - i) < 0 || sb.charAt(j) != sb.charAt(i - (j - i))){
//                            break;
//                        }
//                        right = j;
//                        arr[i] = j - i;
//                    }
//                }else {
//                    arr[i] = arr[2*mid - i];
//                }
//            }
//        }
//        int target = 0;
//        int length = arr[0];
//        for (int i = 2; i < arr.length; i += 2){
//            if (length < arr[i]){
//                target = i;
//                length = arr[i];
//            }
//        }
//        String t1 = s.substring(target/2 - length/2,target/2 + length/2 + 1);
//        target = 1;
//        length = arr[1];
//        for (int i = 1; i < arr.length; i += 2){
//            if (length <= arr[i]){
//                target = i;
//                length = arr[i];
//            }
//        }
//        if (length == 0){
//            return t1;
//        }
//        String t2 = s.substring(target/2 - (length - 1)/2,target/2 + (length - 1)/2 + 2);
//        if (t1.length() >= t2.length()){
//            return t1;
//        }else{
//            return t2;
//        }
//    }
}
