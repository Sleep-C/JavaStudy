package LeetcodeAll.银联专场;

import java.util.Arrays;
import java.util.Comparator;

public class Three {
    public static void main(String[] args) {

    }
    //思路，排序后从右往左遍历阶梯，在阶梯处计算
    //或者二分，寻找一个数使得大于该数的所有都减为该数，得到的操作次数等于给定值
    //https://www.bilibili.com/video/BV1LF411x7fZ
    public int maxInvestment(int[] product, int limit) {
//        Arrays.sort(product,new Comparator<Integer>(){
//            @Override
//            public int compare(Integer x, Integer y){
//                if (x > y){
//                    return -1;
//                }else if (x < y){
//                    return 1;
//                }else {
//                    return 0;
//                }
//            }
//        });
        long result = 0;
        int i = 1;
        return 0;
    }
}
