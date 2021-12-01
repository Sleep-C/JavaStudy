package tencent50;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class eightyNine {
    public static void main(String[] args) {
        System.out.println(grayCode(1));
    }
    //非递归方法
    public static List<Integer> grayCode(int n) {
        int mm = (int)Math.pow(2,n);
        List<Integer> gray = new ArrayList(mm);
        for (int i = 0; i<mm; i++){
            gray.add(0);
        }
        gray.set(0,0);
        gray.set(1,1);
        int m=0;
        for (int i = 1; i<n; i++){
            for (int j = 0; j < Math.pow(2,i); j++){
                gray.set(2*(int)Math.pow(2,i)-j-1,gray.get(j) + (int)Math.pow(2,i));
            }
        }
        return gray;
    }
    //递归方法
//    public static List<Integer> grayCode(int n) {
//        if (n==0){
//            List<Integer> g = new ArrayList<>(2);
//            g.add(0);
//            return g;
//        }
//        if (n==1){
//            List<Integer> g = new ArrayList<>(2);
//            g.add(0);
//            g.add(1);
//            return g;
//        }
//        List<Integer> gray1=grayCode(n-1);
//        List<Integer> gray2=new ArrayList<>(gray1.size()*2);
//        int j=gray1.size();
//        for (int i=0;i<gray1.size();i++){
//            gray2.add(gray1.get(i));
//        }
//        for (int i=0;i<gray1.size();i++){
//            gray2.add(0);
//        }
//        for (int i=0;i<gray1.size();i++){
//            gray2.set(2*gray1.size()-i-1,j+gray1.get(i));
//        }
//
//        return gray2;
//    }
}
