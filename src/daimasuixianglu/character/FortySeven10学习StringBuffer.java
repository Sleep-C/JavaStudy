package daimasuixianglu.character;

public class FortySeven10学习StringBuffer {
    public static void main(String[] args) {

    }
    public static String removeDuplicates(String s) {
        StringBuffer stack = new StringBuffer();
        int top = 0;
        for (int i = 0; i < s.length(); i++){
            if (top > 0 && stack.charAt(top - 1) == s.charAt(i)){
                stack.deleteCharAt(top - 1);
                top--;
            }else{
                stack.append(s.charAt(i));
                top++;
            }
        }
        return stack.toString();
    }
}
