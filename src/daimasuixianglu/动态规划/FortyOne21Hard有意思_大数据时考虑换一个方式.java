package daimasuixianglu.动态规划;

import java.util.Arrays;

public class FortyOne21Hard有意思_大数据时考虑换一个方式 {
    public static void main(String[] args) {

    }

    //思路：如果数组中一个数大于等于一个临界值，那么每次都会减它，即它不会对结果产生影响，可以删去这个数，
    //并且将n-1；这个临界值应当为所有数之和除以n向下取整与最小的batteries.length - n + 1个的
    //数之和的小值
    //删去所有不会对结果产生影响的数后，将剩余数累加除以n向下取整即为最终答案

    //一个非常优雅，非常完美的大佬解答
    public static long maxRunTime(int n, int[] bat) {
        long sum = 0;
        for(int x : bat){
            sum += x;
        }
        while(true){
            long mid = sum / n;
            boolean find = false;
            for(int i = 0; i < bat.length; i++){
                if(bat[i] > mid){
                    n--;
                    sum -= bat[i];
                    bat[i] = 0;
                    find = true;
                }
            }
            if(!find)
                return mid;
        }
    }

    //参考：二分答案，写一个判断函数用来判断给定数据能否撑time次，然后二分遍历这个time
    //写这个函数的冠关键点在于，如果数组中的数大于time，则该数单独分配n中的一个，最终剩余的碎片数据
    //求和/n，结果大于大于time即为true
    //与我思路大体一致，我的方法少了二分，且对于大数据越界没想到处理的办法!!!!!
//    public static long maxRunTime(int n, int[] arr){
//        Arrays.sort(arr);
//        int size = arr.length;
//        long[] sums = new long[size];
//        sums[0] = arr[0];
//        for (int i = 1; i < size; i++){
//            sums[i] = sums[i - 1] + arr[i];
//        }
//        long l = 0;
//        long m = 0;
//        long r = sums[size - 1]/n;
//        long ans = -1;
//        while (l <= r){
//            m = (l + r)/2;
//            if (ok(arr,sums,m,n)){
//                ans = m;
//                l = m + 1;
//            }else {
//                r = m - 1;
//            }
//        }
//        return ans;
//    }
//    public static boolean ok(int[] arr,long[] sum,long time,int num){
//        int l = 0;
//        int m = 0;
//        int r = arr.length - 1;
//        int left = arr.length;
//        while (l <= r){
//            m = (l + r)/2;
//            if (arr[m] >= time){
//                left = m;
//                r = m - 1;
//            }else {
//                l = m + 1;
//            }
//        }
//        num -= arr.length - left;
//        long rest = left == 0?0:sum[left - 1];
//        return time*(long)num <= rest;
//    }



    //大数据尝试失败,研究下大数据处理问题
    //做https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
//    public static long maxRunTime(int n, int[] batteries) {
//        long result = 0;
//        Arrays.sort(batteries);
//        int boundary = batteries.length - 1;
//        int bLength = n;
//        boolean label = true;
//        long[] sum = new long[batteries.length];
//        sum[0] = (long)batteries[0];
//        for (long i = 1; i < batteries.length; i++){
//            sum[(int)i] = (long)(sum[(int)i - 1]/(i + 1))*i + ((long)batteries[(int)i]/(i + 1));
//        }
//        int max = batteries.length - n;
//        while(batteries[boundary]/(max + 1) >= sum[max] && bLength >= 0){
//            boundary--;
//            bLength--;
//        }
//
//        while(label && bLength > 0){
//            label = false;
//            int mid = (int)(sum[boundary]/(long)bLength)*boundary;
//            while(bLength > 0 && batteries[boundary] >= mid){
//                label = true;
//                boundary--;
//                bLength--;
//            }
//        }
//        if (bLength == 0){
//            return sum[boundary]*(long)(boundary + 1);
//        }
//        return (sum[boundary]/(long)bLength)*(long)(boundary + 1);
//    }
    //小数据正确
//    public static long maxRunTime(int n, int[] batteries) {
//        long result = 0;
//        Arrays.sort(batteries);
//        int boundary = batteries.length - 1;
//        int bLength = n;
//        boolean label = true;
//        long[] sum = new long[batteries.length];
//        sum[0] = (long)batteries[0];
//        for (int i = 1; i < batteries.length; i++){
//            sum[i] = sum[i - 1] + (long)batteries[i];
//        }
//        int max = batteries.length - n;
//        while(batteries[boundary] >= sum[max] && bLength >= 0){
//            boundary--;
//            bLength--;
//        }
//        while(label && bLength >= 0){
//            label = false;
//            int mid = (int)(sum[boundary]/(long)bLength);
//            while(batteries[boundary] >= mid){
//                label = true;
//                boundary--;
//                bLength--;
//            }
//        }
//        if (bLength == 0){
//            return sum[boundary];
//        }
//        return sum[boundary]/(long)bLength;
//    }
}
