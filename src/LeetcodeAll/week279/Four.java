package LeetcodeAll.week279;

import java.util.ArrayList;
import java.util.List;

public class Four {
    public static void main(String[] args) {
        System.out.println(minimumTime("1100101"));
    }
    public static int minimumTime(String s) {
        int num = s.length();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++){
            if (s.charAt(i) == '1'){
                list.add(i);
            }
        }
        int[] t1 = new int[list.size()];
        int[] t2 = new int[list.size()];
        //遍历到每一个时，比较前一个用时加2与移除前面所有用时
        //哪个时间更短
        if (list.size() == 0){
            return 0;
        }
        if (list.get(0) > 0){
            t1[0] = 2;
        }else {
            t1[0] = 1;
        }
        for (int i = 1; i < list.size(); i++){
            if (t1[i - 1] + 2 < list.get(i) + 1){
                t1[i] = t1[i - 1] + 2;
            }else {
                t1[i] = list.get(i) + 1;
            }
        }
        if (list.get(list.size() - 1) < num - 1){
            t2[list.size() - 1] = 2;
        }else {
            t2[list.size() - 1] = 1;
        }
        for (int i = list.size() - 2; i >= 0; i--){
            if (t2[i + 1] + 2 < num - list.get(i)){
                t2[i] = t2[i + 1] + 2;
            }else{
                t2[i] = num - list.get(i);
            }
        }
        int result;
        if (t2[0] > t1[t1.length - 1]){
            result = t1[t1.length - 1];
        }else {
            result = t2[0];
        }
        //这里的i代表i及以前的从左边取
        for (int i = 0; i < t1.length - 1; i++){
            if (result > t1[i] + t2[i + 1]){
                result = t1[i] + t2[i + 1];
            }
        }
        return result;
    }
}
