package daimasuixianglu.character;

public class FiftyNine4已完成但考虑用KMP再做一次仔细看答案 {
    public static void main(String[] args) {

    }
    public static boolean repeatedSubstringPattern(String s) {
        char firstStr = s.charAt(0);
        char lastStr = s.charAt(s.length() - 1);
        int label = 0;
        for (int i = 0; i < s.length()/2; i++){
            if (firstStr == s.charAt(i + 1) && lastStr == s.charAt(i) && s.length()%(i + 1) == 0){
                label = 1;
                int k = 0;
                for (int j = i + 1; j < s.length(); j++){
                    if (s.charAt(k) != s.charAt(j)){
                        label = 0;
                        break;
                    }
                    k++;
                    if (k == i + 1){
                        k = 0;
                    }
                }
                if (label == 1 && k == 0){
                    return true;
                }else{
                    label = 0;
                }
            }
        }
        if (label == 0){
            return false;
        }else{
            return true;
        }
    }
}
