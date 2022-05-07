package daimasuixianglu.回溯;

public class ThirtyEight7int与char互相转换 {
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(90));
    }
    public static int monotoneIncreasingDigits(int n) {
        StringBuffer s = new StringBuffer(n + "");
        int label = 0;
        while(label < s.length() - 1 && s.charAt(label) <= s.charAt(label + 1)){
            label++;
        }
        if (label == s.length() - 1){
            return Integer.parseInt(s.toString());
        }
        while(label > 0 && s.charAt(label) == s.charAt(label - 1)){
            label--;
        }
        //重点在于char与int的互相转换
        s.setCharAt(label,String.valueOf(s.charAt(label) - 1 - '0').toCharArray()[0]);
        label++;
        for (; label < s.length(); label++){
            s.setCharAt(label,'9');
        }
        return Integer.parseInt(s.toString());
    }
}
