package LeetcodeAll.week280;

import java.util.HashMap;
import java.util.Map;

public class Two {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{3,3,3,3,4,3,3,4,5,1,5,7,8,7}));
    }
    public static int minimumOperations(int[] nums) {
        if (nums.length <= 2){
            if (nums.length == 2 && nums[0] == nums[1]){
                return 1;
            }
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        int max_2 = nums[1];
        int max2_2 = nums[1];
        int max = nums[0];
        int max2 = nums[0];
        for (int i = 0; i < nums.length; i += 2){
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) + 1);
                if (max == nums[i]){
                    continue;
                }
                if (map.get(nums[i]) >= map.get(max)){
                    max2 = max;
                    max = nums[i];
                }else if (map.get(nums[i]) > map.get(max2)){
                    max2 = nums[i];
                }
            }else {
                map.put(nums[i],1);
                if (max == max2){
                    max2 = nums[i];
                }
            }
        }
        for (int i = 1; i < nums.length; i += 2){
            if (map2.containsKey(nums[i])){
                map2.put(nums[i],map2.get(nums[i]) + 1);
                if (nums[i] == max_2){
                    continue;
                }
                if (map2.get(nums[i]) >= map2.get(max_2)){
                    max2_2 = max_2;
                    max_2 = nums[i];
                }else if(nums[i] > map2.get(max2_2)){
                    max2_2 = nums[i];
                }
            }else {
                map2.put(nums[i],1);
                if (max_2 == max2_2){
                    max2_2 = nums[i];
                }
            }
        }
        if (max == max2 && max2_2 == max_2){
            if (max == max_2){
                return map2.get(max_2);
            }else {
                return 0;
            }
        }else{
            if (max2 == max){
                if (max == max_2){
                    return nums.length/2 - map2.get(max2_2);
                }else {
                    return nums.length/2 - map2.get(max_2);
                }
            }else if (max2_2 == max_2){
                if (max == max_2){
                    return nums.length/2 + nums.length%2 - map.get(max2);
                }else {
                    return nums.length/2 + nums.length%2 - map.get(max);
                }
            }else{
                if (max != max_2){
                    return nums.length - map.get(max) - map2.get(max_2);
                }else{
                    if (map.get(max) + map2.get(max2_2) >= map.get(max2) + map2.get(max_2)){
                        return nums.length - map.get(max) - map2.get(max2_2);
                    }else {
                        return nums.length - map.get(max2) - map2.get(max_2);
                    }
                }
            }
        }
    }
}
