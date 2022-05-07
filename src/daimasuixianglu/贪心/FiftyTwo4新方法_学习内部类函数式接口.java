package daimasuixianglu.贪心;

import java.util.*;

public class FiftyTwo4新方法_学习内部类函数式接口 {
    public static void main(String[] args) {
        int m = 'x' - 'a';
        List<Integer> list = new ArrayList<>();
        System.out.println(findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));

    }
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0){
            return 0;
        }
        //与第四种方法速度相同
        //内部类
        class MyCompare implements Comparator<int[]>{
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]){
                    return 1;
                }else if (point1[1] < point2[1]){
                    return -1;
                }else {
                    return 0;
                }
            }
        }
        Arrays.sort(points,new MyCompare());
        
        //这里会可能出现越界问题，所以最好用下面的种方法
//        Arrays.sort(points,(myPoint1,myPoint2)->myPoint1[1] - myPoint2[1]);

        //lambda表达式速度比下面的方法要慢一些
        // Arrays.sort(points, (point1, point2)->{
        //         if (point1[1] > point2[1]){
        //             return 1;
        //         }else if (point1[1] < point2[1]){
        //             return -1;
        //         }else {
        //             return 0;
        //         }
        // });

        //函数式接口
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] point1, int[] point2) {
//                if (point1[1] > point2[1]){
//                    return 1;
//                }else if (point1[1] < point2[1]){
//                    return -1;
//                }else {
//                    return 0;
//                }
//            }
//        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points){
            if (balloon[0] > pos){
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
