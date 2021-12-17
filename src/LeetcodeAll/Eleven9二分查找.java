package LeetcodeAll;

import java.util.HashMap;
import java.util.Map;

public class Eleven9二分查找 {
    public static void main(String[] args) {
        Eleven9二分查找 e = new Eleven9二分查找(new int[]{0, 1, 2, 2, 1}, new int[]{20,28,29,54,56});
        System.out.println(e.q(56));
    }
    int[] times;
    Map<Integer, Integer> map;
    public Eleven9二分查找(int[] persons, int[] times) {
        this.times = times;
        int[] order = new int[persons.length];
        map = new HashMap<>();
        map.put(times[0],persons[0]);
        order[persons[0]]++;
        for (int i = 1; i < persons.length; i++){
            order[persons[i]]++;
            if (order[persons[i]] >= order[map.get(times[i - 1])]){
                map.put(times[i],persons[i]);
            }else {
                map.put(times[i],map.get(times[i - 1]));
            }
        }
    }

    public int q(int t) {
        // int i = 0;
        // for ( ; i < times.length; i++){
        //     if (times[i] > t){
        //         i--;
        //         break;
        //     }
        // }
        // if (i == times.length){
        //     i--;
        // }
        // return map.get(times[i]);
        int left = 0;
        int right = times.length - 1;
        for ( ; left < right - 1; ){
            if (times[(left + right)/2] > t){
                right = (left + right)/2;
            }else if (times[(left + right)/2] < t){
                left = (left + right)/2;
            }else {
                break;
            }
        }
        if (times[right] <= t){
            return map.get(times[right]);
        }else{
            return map.get(times[(right + left)/2]);
        }
    }
}
