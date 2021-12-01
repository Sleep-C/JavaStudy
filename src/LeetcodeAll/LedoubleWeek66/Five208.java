package LeetcodeAll.LedoubleWeek66;

import java.util.HashMap;
import java.util.Map;

public class Five208 {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
    }
    public int countWords(String[] words1, String[] words2) {
        Map<String ,Integer> map = new HashMap<>();
        if (words1.length > words2.length){
            String[] middle = words1;
            words1 = words2;
            words2 = middle;
        }
        for (int i = 0; i < words1.length; i++){
            if (map.containsKey(words1[i])){
                map.put(words1[i],-1);
            }else{
                map.put(words1[i],1);
            }
        }
        //不注释这个报错
        // for (String key:map.keySet()){
        //     if (map.get(key) == 2){
        //         map.remove(key);
        //     }
        // }
        for (int i = 0; i < words2.length; i++){
            if (map.containsKey(words2[i])){
                map.put(words2[i],map.get(words2[i]) - 1);
            }
        }
        int i = 0;
        for (Integer value:map.values()){
            if (value == 0){
                i++;
            }
        }
        return i;
    }
//    public static int countWords(String[] words1, String[] words2) {
//        Map<String ,Integer> map = new HashMap<>();
//        if (words1.length > words2.length){
//            String[] middle = words1;
//            words1 = words2;
//            words2 = middle;
//        }
//        for (int i = 0; i < words1.length; i++){
//            if (map.containsKey(words1[i])){
//                map.put(words1[i],2);
//            }else{
//                map.put(words1[i],1);
//            }
//        }
//        for (String key:map.keySet()){
//            if (map.get(key) == 2){
//                map.remove(key);
//            }
//        }
//        for (int i = 0; i < words2.length; i++){
//            if (map.containsKey(words2[i])){
//                map.put(words2[i],map.get(words2[i]) - 1);
//            }
//        }
//        int i = 0;
//        for (Integer value:map.values()){
//            if (value == 0){
//                i++;
//            }
//        }
//        return i;
//    }
}
