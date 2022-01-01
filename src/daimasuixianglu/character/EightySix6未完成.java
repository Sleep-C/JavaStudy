package daimasuixianglu.character;

public class EightySix6未完成 {
    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("aaaaaaaaaaaaaaaaaaaaaab","ba"));
    }
    public static int repeatedStringMatch(String a, String b) {
        int result = 1;
        int a_label = -1;
        for (int j = 0; j < a.length(); j++){
            int b_label = 0;
            for (int i = j; i < a.length(); ){
                if (a.charAt(i) != b.charAt(b_label)){
                    break;
                }
                i++;
                b_label++;
                if (b_label == b.length() && a.length() > b.length()){
                    return 1;
                }
                if (i == a.length()){
                    i = 0;
                }
                if (i == j){
                    a_label = j;
                    break;
                }
            }
            if (a_label != -1){
                break;
            }
        }
        if (a_label == -1){
            return -1;
        }
        for (int i = 0; i < b.length(); i++){
            if (a.charAt(a_label) != b.charAt(i)){
                return -1;
            }
            a_label++;
            if (a_label == a.length() && i != b.length() - 1){
                result++;
                a_label = 0;
            }
        }
        return result;
    }
}
