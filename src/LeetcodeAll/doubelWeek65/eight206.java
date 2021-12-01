package LeetcodeAll.doubelWeek65;

import java.util.HashMap;
import java.util.Map;

public class eight206 {
    public static void main(String[] args) {
        System.out.println(checkAlmostEquivalent("aaaa","bccb"));
    }
    //我的思路，用map存储每一个字符的数量。

    public static boolean checkAlmostEquivalent(String word1, String word2) {
        Map<Character,Integer> out = new HashMap<>();
        for (int i = 0; i<word1.length(); i++){
            if (out.containsKey(word1.charAt(i))){
                out.put(word1.charAt(i),out.get(word1.charAt(i)) + 1);
            }else {
                out.put(word1.charAt(i),1);
            }
        }
        for (int i = 0; i<word2.length(); i++){
            if (out.containsKey(word2.charAt(i))){
                out.put(word2.charAt(i),out.get(word2.charAt(i)) - 1);
            }else {
                out.put(word2.charAt(i), -1);
            }
        }
        for (Integer v:out.values()){
            if (Math.abs(v) > 3){
                return false;
            }
        }
        return true;
    }
}
