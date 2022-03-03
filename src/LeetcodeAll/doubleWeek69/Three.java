package LeetcodeAll.doubleWeek69;

import java.util.HashMap;
import java.util.Map;

public class Three {
    public static void main(String[] args) {
        System.out.println(longestPalindrome(new String[]{"ll","lb","bb","bx","xx","lx","xx","lx","ll","xb","bx","lb","bb","lb","bl","bb","bx","xl","lb","xx"}));
        //应该为26
    }
    public static int longestPalindrome(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            if (map.containsKey(words[i])){
                map.put(words[i], map.get(words[i]) + 1);
            }else {
                map.put(words[i], 1);
            }
        }
        int re = 0;
        for (int i = 0; i < words.length; i++){
            if (words[i].charAt(0) == words[i].charAt(1)){
                if (map.get(words[i]) >= 2){
                    re += 4;
                    map.put(words[i], map.get(words[i]) - 2);
                }
            }else {
                String tmp = "" + words[i].charAt(1) + words[i].charAt(0);
                if (map.containsKey(tmp) && map.get(tmp) > 0){
                    re += 2;
                    map.put(tmp, map.get(tmp) - 1);
                }
            }
        }
        for (int i = 0; i < words.length; i++){
            if (words[i].charAt(0) == words[i].charAt(1) && map.containsKey(words[i]) && map.get(words[i]) > 0){
                re += 2;
                return re;
            }
        }
        return re;
    }
}
