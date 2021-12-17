package LeetcodeAll.doubleWeek67;

import java.util.ArrayList;
import java.util.List;

public class Zero21暴力破解_滑动窗口 {
    public static void main(String[] args) {
        System.out.println(goodDaysToRobBank(new int[]{1,2,5,4,1,0,2,4,5,3,1,2,4,3,2,4,8},2));
    }
    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> list = new ArrayList<>();
        int label1 = 0;
        int label2 = 0;
        if (security.length < 2*time + 1){
            return list;
        }
        for (int i = time; i >0 ; i--){
            if (security[i] > security[i - 1]){
                break;
            }
            label1++;
        }
        for (int i = 2*time; i > time; i--){
            if (security[i] < security[i - 1]){
                break;
            }
            label2++;
        }
        for (int i = time; i < security.length - time; i++){
            if (label1 == time && label2 == time){
                list.add(i);
            }
            if (i == security.length - time - 1){
                break;
            }
            if (security[i] < security[i + 1]){
                label1 = 0;
            }else{
                label1++;
                if (label1 > time){
                    label1 = time;
                }
            }
            if (security[i + time] > security[i + time + 1]){
                label2 = 0;
            }else{
                label2++;
                if (label2 > time){
                    label2 = time;
                }
            }
        }
        return list;
    }
    //暴力破解超时
//    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
//        List<Integer> list = new ArrayList<>();
//        if (time == 0){
//            for (int i = 0; i < security.length; i++){
//                list.add(i);
//            }
//            return list;
//        }
//        for (int i = 2*time; i < security.length; i++){
//            int label = 0;
//            for (int j = i - 2*time; j < i - time; j++){
//                if (security[j] < security[j + 1]){
//                    label = 1;
//                    break;
//                }
//                if (security[2*i - 2*time - j] < security[2*i - 2*time - j - 1]){
//                    label = 1;
//                    break;
//                }
//            }
//            if (label == 0){
//                list.add(i - time);
//            }
//        }
//        return list;
//    }
}
