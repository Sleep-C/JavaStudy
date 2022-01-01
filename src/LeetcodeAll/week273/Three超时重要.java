package LeetcodeAll.week273;

import java.util.*;

public class Three超时重要 {
    public static void main(String[] args) {
        System.out.println(getDistances(new int[]{2,1,3,1,2,3,3}));
    }
    public static long[] getDistances(int[] arr) {
        long[] result = new long[arr.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            if (map.containsKey(arr[i])){
                List<Integer> list = map.get(arr[i]);
                list.add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i],list);
            }
        }
        for (List<Integer> list : map.values()){
            for (int i = 0; i < list.size(); i++){
                for (int j = 0; j < list.size(); j++){
                    result[list.get(i)] += Math.abs(list.get(i) - list.get(j));
                }
            }
        }
        return result;
    }
}
