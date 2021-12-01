package daimasuixianglu.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThirtyEight4滑动窗口可以维护两个map一个变判断map是否相等 {
    public static void main(String[] args) {

    }
    public static List<Integer> findAnagrams(String s, String p) {
        //考虑滑动窗口
        if (s.length() < p.length()){
            return new ArrayList<>();
        }
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < p.length(); i++){
            if (map.containsKey(p.charAt(i))){
                map.put(p.charAt(i),map.get(p.charAt(i)) + 1);
            }else{
                map.put(p.charAt(i),1);
            }
        }
        int j = 0;
        int k = p.length() - 1;
        for (int i = 0; i < p.length(); i++){
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i)) - 1);
            }
        }
        for (;;){
            int label = 0;
            for (Integer value:map.values()){
                if (value != 0){
                    label = 1;
                    break;
                }
            }
            if (label == 0){
                list.add(j);
            }
            if (map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),map.get(s.charAt(j)) + 1);
            }
            j++;
            k++;
            if (k == s.length()){
                break;
            }
            if (map.containsKey(s.charAt(k))){
                map.put(s.charAt(k),map.get(s.charAt(k)) - 1);
            }
        }
        return list;
    }
}