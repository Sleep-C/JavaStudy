package daimasuixianglu.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourtySeven官方去重处理有意思 {
    public static void main(String[] args) {

    }
    //官方解答，去重方式很有意思
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            //这里就是官方解法的精髓，核心思路其实和我的一样，但方式更加巧妙简介
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            //********
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }
    //我的解答是用数组存储每一个数出现的次数
//    int[] arr = new int[21];
//    int m;
//    List<List<Integer>> result = new ArrayList<>();
//    List<Integer> tmp = new ArrayList<>();
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        m = nums.length;
//        for (int i = 0; i < m; i++){
//            arr[nums[i] + 10]++;
//        }
//        helper(0);
//        return result;
//    }
//    public void helper(int n){
//        if (n == m){
//            result.add(new ArrayList(tmp));
//            return;
//        }
//        for (int i = 0; i < arr.length; i++){
//            if (arr[i] != 0){
//                arr[i]--;
//                tmp.add(i - 10);
//                helper(n + 1);
//                tmp.remove(tmp.size() - 1);
//                arr[i]++;
//            }
//        }
//    }
}
