package daimasuixianglu.character;

public class FiftyOne1 {
    public static void main(String[] args) {
        System.out.println(reverseWords("  Bob    Loves  Alice   "));
    }
    public static String reverseWords(String s) {
        StringBuffer str = new StringBuffer();
        String[] s1 = s.split(" ");
        for (int i = s1.length - 1; i >= 0; i--){
            if (s1[i].length() == 0){
                continue;
            }
            str.append(s1[i]);
            str.append(" ");
        }
        str.deleteCharAt(str.length() - 1);
        return str.toString();
    }
}
