package LeetcodeAll.week273有些解答看不懂;

import java.util.*;

public class Three_map处理思路重要_看不懂最佳解答 {
    public static void main(String[] args) {
        System.out.println(getDistances(new int[]{10,5,10,10}));
    }
    //看不懂的最佳解答
//    public long[] getDistances(int[] arr) {
//        int n = arr.length;
//        long[] ans = new long[n];
//        int max = 0;
//        for (int i = 0; i < n; i++) max = Math.max(max, arr[i]);
//        long[] sum = new long[max + 1];
//        int[] cnt = new int[max + 1];
//        for (int i = 0; i < n; i++) {
//            int num = arr[i];
//            ans[i] += (long) cnt[num] * i - sum[num];
//            sum[num] += i;
//            cnt[num]++;
//        }
//
//        for (int i = 0; i <= max; i++) sum[i] = cnt[i] = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            int num = arr[i];
//            ans[i] += sum[num] - (long) cnt[num] * i;
//            sum[num] += i;
//            cnt[num]++;
//        }
//
//        return ans;
//    }
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
                if (i ==0){
                    for (int j = 0; j < list.size(); j++){
                        result[list.get(i)] += Math.abs(list.get(i) - list.get(j));
                    }
                }else{
                    result[list.get(i)] = result[list.get(i - 1)] - (list.get(i) - list.get(i - 1))*(list.size() - i - i);
                }
            }
        }
        return result;
    }
}
