package LeetcodeAll;

public class SeventyTwo3整数运算溢出的处理方式未完成 {
    public static void main(String[] args) {

    }
    public static int superPow(int a, int[] b) {
        int out = 1;
        a = a%1337;
        out = (int)Math.pow(a,b[b.length - 1])%1337;
        for (int i = b.length - 2; i >= 0; i--){
            for (int j = 0; j < 9; j++){
                a = (a * a)%1337;
            }
            int c = a;
            if (b[i] != 0){
                for (int j = 0; j < b[i] - 1; j++){
                    c = (c * c)%1337;
                }
                out *= c;
                out %= 1337;
            }

        }
        return out;
    }
//    public static int superPow(int a, int[] b) {
//        int out = 1;
//        a = a%1337;
//        out = (int)Math.pow(a,b[b.length - 1])%1337;
//        for (int i = b.length - 2; i >= 0; i--){
//            for (int j = 0; j < 9; j++){
//                a = (a * a)%1337;
//            }
//            int c = a;
//            if (b[i] != 0){
//                for (int j = 0; j < b[i] - 1; j++){
//                    c = (c * c)%1337;
//                }
//                out *= c;
//                out %= 1337;
//            }
//
//        }
//        return out;
//    }
}
