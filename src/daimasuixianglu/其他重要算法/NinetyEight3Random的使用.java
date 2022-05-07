package daimasuixianglu.其他重要算法;

import java.util.*;

public class NinetyEight3Random的使用 {
    public static void main(String[] args) {

    }
    Map<Integer, List<Integer>> map;
    Random random;
    public NinetyEight3Random的使用(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                List<Integer> list = map.get(nums[i]);
                list.add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i],list);
            }
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}
