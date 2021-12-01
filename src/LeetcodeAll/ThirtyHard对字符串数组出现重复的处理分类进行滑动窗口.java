package LeetcodeAll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThirtyHard对字符串数组出现重复的处理分类进行滑动窗口 {
    public static void main(String[] args) {
        System.out.println(findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    }
    //考虑滑动窗口，将数据分为words[0].length()组，每一组进行出入words[0].length()个字符的滑动窗口。每组的的差别在于开始字符迁移1个字符
    public static List<Integer> findSubstring(String s, String[] words) {
        Map<Integer,Integer> map = new HashMap<>();
        int w_length = words[0].length();
        for (int i = 0; i <= s.length() - w_length; i++){
            for (int j = 0; j < words.length; j++){
                if (words[j].equals(s.substring( i, i + w_length))){
                    map.put(i,j);
                    break;
                }
            }
        }
        //处理数组中可能的重复。。。对于{"bar","foo","the","bar"}数组，设立一个长度为4的数组标记其在一段字符串出现的次数，其中第一个bar的值为bar的总数，后面的bar为0.我需要判断的条件是数组全0
        Map<String,Integer> new_map = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            if (new_map.containsKey(words[i])){
                new_map.put(words[i],new_map.get(words[i]) + 1);
            }else {
                new_map.put(words[i],1);
            }
        }
        int[] new_words = new int[words.length];
        for (int i = 0; i < words.length; i++){
            new_words[i] = new_map.get(words[i]);
            new_map.put(words[i],0);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= s.length() - words.length*w_length; i++){
            int[] label = new_words.clone();
            int j = i;
            while (map.containsKey(j) && label[map.get(j)] != 0){
                label[map.get(j)] -= 1;
                j += w_length;
            }
            int label2 = 0;
            for (int k = 0; k < label.length; k++){
                if (label[k] != 0){
                    label2 = 1;
                }
            }
            if (label2 == 0){
                list.add(i);
            }
        }
        return list;
    }
}
