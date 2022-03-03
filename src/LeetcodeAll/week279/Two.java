package LeetcodeAll.week279;

import java.util.HashMap;
import java.util.Map;

public class Two {
    public static void main(String[] args) {

    }
    public static long smallestNumber(long num) {
        String str = String.valueOf(num);
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            String ch = "" + str.charAt(i);
            if (map.containsKey(ch)){
                map.put(ch,map.get(ch) + 1);
            }else {
                map.put(ch,1);
            }
        }
        StringBuffer s = new StringBuffer();
        if (map.containsKey("-")){
            for (int i = 9; i >= 0; i--){
                if (map.containsKey("" + i)){
                    while (map.get("" + i) > 0){
                        s.append(i);
                        map.put("" + i,map.get("" + i) - 1);
                    }
                }
            }
            return -Long.valueOf(s.toString());
        }else {
            int i = 1;
            for (; i < 10; i++){
                if (map.containsKey("" + i)){
                    map.put("" + i,map.get("" + i) - 1);
                    s.append(i);
                    break;
                }
            }
            if (map.containsKey("0")){
                while (map.get("0") > 0){
                    s.append(0);
                    map.put("0",map.get("0") - 1);
                }
            }
            for (; i < 10; i++){
                if (map.containsKey("" + i)){
                    while (map.get("" + i) > 0){
                        map.put("" + i,map.get("" + i) - 1);
                        s.append(i);
                    }
                }
            }
            return Long.valueOf(s.toString());
        }
    }
}
