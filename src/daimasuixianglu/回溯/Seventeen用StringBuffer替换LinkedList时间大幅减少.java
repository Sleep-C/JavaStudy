package daimasuixianglu.回溯;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Seventeen用StringBuffer替换LinkedList时间大幅减少 {
    public static void main(String[] args) {

    }
    static Map<Character,String> map = new HashMap<>();
    static StringBuffer tmp = new StringBuffer();
    static List<String> result = new LinkedList<>();
    public static List<String> letterCombinations(String digits) {
        if (digits.equals("")){
            return result;
        }
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        helper(0,digits);
        return result;
    }
    public static void helper(int k, String digits){
        String mid = map.get(digits.charAt(k));
        for (int i = 0; i < mid.length(); i++){
            tmp.append(mid.charAt(i));
            if (k == digits.length() - 1){
                result.add(String.join("",tmp));
            }else {
                helper(k + 1, digits);
            }
            tmp.deleteCharAt(k);
        }
    }
}
