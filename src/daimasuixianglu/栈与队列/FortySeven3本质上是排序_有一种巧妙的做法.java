package daimasuixianglu.栈与队列;

import java.util.HashMap;
import java.util.Map;

public class FortySeven3本质上是排序_有一种巧妙的做法 {
    public static void main(String[] args) {

    }
    //一种巧妙的做法，找出最大的，然后向下遍历
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];    // 结果数组
        Map<Integer, Integer> map = new HashMap();
        // 统计数组中各元素出现的次数
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else{
                map.put(num, 1);
            }
        }

        int maxTimes = 0;    // 出现最多的元素的出现次数
        // 找出出现次数最多的元素出现的次数
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > maxTimes){
                maxTimes = entry.getValue();
            }
        }

        // 按出现次数从大到小添加到结果数组
        while(k > 0){
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue() == maxTimes){
                    res[k - 1] = entry.getKey();
                    k--;
                }
            }
            maxTimes--;
        }

        return res;
    }
    // public static int[] topKFrequent(int[] nums, int k) {
    //     int[] out = new int[k];
    //     Map<Integer,Integer> map = new HashMap<>();
    //     for (int i = 0; i < nums.length; i++){
    //         if (map.containsKey(nums[i])){
    //             map.put(nums[i],map.get(nums[i]) + 1);
    //         }else{
    //             map.put(nums[i],1);
    //         }
    //     }
    //     if (!map.containsKey(0)){
    //         map.put(0,0);
    //     }else{
    //         int min = 100000;
    //         int label = 0;
    //         for (Integer key : map.keySet()){
    //             if (map.get(key) < min){
    //                 min = map.get(key);
    //                 label = key;
    //             }
    //         }
    //         for (int i = 0; i < k; i++){
    //             out[i] = label;
    //         }
    //     }
    //     for (Integer key: map.keySet()){
    //         if (map.get(key) > map.get(out[0])){
    //             for (int i = 1; i < k; i++){
    //                 if (map.get(key) <= map.get(out[i])){
    //                     out[i - 1] = key;
    //                     break;
    //                 }else{
    //                     out[i - 1] = out[i];
    //                 }
    //             }
    //             if (map.get(key) > map.get(out[k - 1])){
    //                 out[k - 1] = key;
    //             }
    //         }
    //     }
    //     return out;
    // }
}
