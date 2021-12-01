package daimasuixianglu.hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FortyTwo2标准答案用char的ASCII码映射到数组 {
    public static void main(String[] args) {
        System.out.println(isAnagram("",""));
    }
    public static boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i)) + 1);

            }else {
                map.put(s.charAt(i),1);
            }
        }
        for (int i = 0; i < t.length(); i++){
            if (map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i)) - 1);
            }else {
                return false;
            }
        }
        for (Integer key : map.values()){
            if (key != 0){
                return false;
            }
        }
        return true;
    }
}
