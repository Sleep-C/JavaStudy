package daimasuixianglu.回溯;

import java.util.*;

public class Test写在方法外的变量如果要在static方法中调用必须在变量前加static {

    public static void main(String[] args) {
        System.out.println(findSubsequences(new int[]{84,-48,-33,-34,-52,72,75,-12,72,-45}));
    }
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> tmp = new ArrayList<>();
    static Set<List<Integer>> set = new HashSet<>();
    public static List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums, 0);
        return result;
    }
    public static void helper(int[] nums, int start){
        for (int i = start; i < nums.length; i++){
            if (i > start && nums[i] == nums[i - 1]) continue;
            if (start == 0 || nums[i] >= nums[start - 1]){
                tmp.add(nums[i]);
                if (tmp.size() > 1 && !set.contains(tmp)){
//                    set.add(tmp);
                    result.add(new ArrayList<>(tmp));
                    set.add(result.get(result.size() - 1));
                }
                helper(nums, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
