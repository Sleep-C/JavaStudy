package LeetcodeAll.week272;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Two背_切割字符串加入stringbuffer {
    public static void main(String[] args) {
        System.out.println(addSpaces("LeetcodeHelpsMeLearn",new int[]{8,13,15}));
    }
    public static String addSpaces(String s, int[] spaces) {
        StringBuffer buffer = new StringBuffer();
        int start = 0;
        for (int i = 0; i < spaces.length; i++) {
            buffer.append(s.substring(start, spaces[i])).append(" ");
            start = spaces[i];
        }
        buffer.append(s.substring(start));
        return buffer.toString();
    }
//    public static String addSpaces(String s, int[] spaces) {
//////        StringBuffer str = new StringBuffer(s);
//////        String str = s.toString();//****
////        List<Character> str1 = new LinkedList<>();
////        Iterator<Character> iterator = str1.iterator();
////
////        for (int i = spaces.length - 1; i >= 0; i--){
//////            str.insert(spaces[i]," ");
////        }
////        return str.toString();
//    }
}
