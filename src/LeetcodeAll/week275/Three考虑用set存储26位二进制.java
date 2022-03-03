package LeetcodeAll.week275;

import java.util.HashSet;
import java.util.Set;

public class Three考虑用set存储26位二进制 {
    public static void main(String[] args) {

    }
    //原方法超时
    public static int wordCount(String[] startWords, String[] targetWords) {
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < targetWords.length; i++){
            set.clear();
            for (int j = 0; j < targetWords[i].length(); j++){
                set.add(targetWords[i].charAt(j));
            }
            for (int j = 0; j < startWords.length; j++){
                if (startWords[j].length() == targetWords[i].length() - 1){
                    int k = 0;
                    for (; k < startWords[j].length(); k++){
                        if (!set.contains(startWords[j].charAt(k))){
                            break;
                        }
                    }
                    if (k == startWords[j].length()){
                        result++;
                        break;
                    }
                }
            }
        }
        return result;
    }
}
