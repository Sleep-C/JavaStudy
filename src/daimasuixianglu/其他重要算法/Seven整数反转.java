package daimasuixianglu.其他重要算法;

public class Seven整数反转 {
    public static void main(String[] args) {
//        String s = "123456456465464546465465445456";
//        String ss = "2";
//        String sss = "1";
//        int i = Integer.MAX_VALUE;
//        String is = Integer.toString(i);
//        if ( || ss.compareTo(sss) < 0){
//            System.out.println("1111");
//        }
//        System.out.println(reverse(123));
    }
    //官方解答......*****使用数学的方法
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
    //我的解答
//    public static int reverse(int x) {
//        StringBuilder sb = new StringBuilder(x + "");
//        int left = 0;
//        int right = sb.length() - 1;
//        if (sb.charAt(0) == '-'){
//            left = 1;
//        }
//        while (left < right){
//            char mid = sb.charAt(left);
//            sb.setCharAt(left,sb.charAt(right));
//            sb.setCharAt(right, mid);
//            left++;
//            right--;
//        }
//        String s = sb.toString();
//        if (x > 0 && s.length() == (Integer.MAX_VALUE + "").length() && s.compareTo(Integer.MAX_VALUE + "") > 0){
//            return 0;
//        }
//
//        if (x < 0 && s.length() == (Integer.MIN_VALUE + "").length() && s.compareTo(Integer.MIN_VALUE + "") > 0){
//            return 0;
//        }
//        return Integer.parseInt(s);
//    }
}
