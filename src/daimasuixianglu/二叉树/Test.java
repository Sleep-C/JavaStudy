package daimasuixianglu.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        System.out.println(superPow(2,new int[]{1,0,1}));
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(list.get(0));
    }
    //372
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
