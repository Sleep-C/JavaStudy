package daimasuixianglu.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NinetyOne4_先1392再优化及看答案未完成_如果Set存储的是对象_那么一定要new一个新对象存储进去 {
    public static void main(String[] args) {

    }
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> tmp = new ArrayList<>();
    //使用List的contains方法会非常慢
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
                    result.add(new ArrayList<>(tmp));
                    set.add(result.get(result.size() - 1));
                }
                helper(nums, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
