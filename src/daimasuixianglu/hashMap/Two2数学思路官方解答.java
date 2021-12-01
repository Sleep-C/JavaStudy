package daimasuixianglu.hashMap;

import java.util.HashSet;
import java.util.Set;

public class Two2数学思路官方解答 {
    public static void main(String[] args) {

    }
    //如果出现循环，那么一定会有重复使用的三位数，用map存储，发现重复直接break
    private int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

}
