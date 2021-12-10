package daimasuixianglu.hashMap;

import java.util.Map;

public class EightyThree3对于英文字符相关考虑用长度26的数组处理 {
    public static void main(String[] args) {

    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] label = new int[26];
        for (int i = 0; i < ransomNote.length(); i++){
            label[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++){
            label[magazine.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if (label[i] > 0){
                return false;
            }
        }
        return true;
    }
}
