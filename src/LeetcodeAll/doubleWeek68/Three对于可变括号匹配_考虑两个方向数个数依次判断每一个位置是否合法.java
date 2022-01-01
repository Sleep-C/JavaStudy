package LeetcodeAll.doubleWeek68;

import java.util.Stack;

public class Three对于可变括号匹配_考虑两个方向数个数依次判断每一个位置是否合法 {
    public static void main(String[] args) {
        System.out.println(canBeValid("())(()(()(())()())(())((())(()())((())))))(((((((())(()))))(","100011110110011011010111100111011101111110000101001101001111"));
        //false
    }
    public static boolean canBeValid(String s, String locked) {
        if (s.length() %2 == 1){
            return false;
        }
        int label1_r = 0;
        int label1_l = 0;
        int label_0 = 0;
        for (int i = 0; i <s.length(); i++){
            if (locked.charAt(i) == '0'){
                label_0++;
            }else if(s.charAt(i) == '('){
                label1_r++;
            }else {
                label1_l++;
            }
            if (label1_l > label1_r + label_0){
                return false;
            }
        }
        label1_l = 0;
        label1_r = 0;
        label_0 = 0;
        for (int i = s.length() - 1; i >=0; i--){
            if (locked.charAt(i) == '0'){
                label_0++;
            }else if(s.charAt(i) == '('){
                label1_r++;
            }else {
                label1_l++;
            }
            if (label1_r > label1_l + label_0){
                return false;
            }
        }
        return true;
    }
}
