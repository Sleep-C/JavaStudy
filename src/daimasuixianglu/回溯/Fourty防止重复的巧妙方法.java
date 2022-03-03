package daimasuixianglu.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fourty防止重复的巧妙方法 {
    public static void main(String[] args) {

    }
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0);
        return result;
    }
    public void helper(int[] cand, int target, int last){
        if (target == 0){
            result.add(new ArrayList(tmp));
            return;
        }
        if (last == cand.length || target < cand[last]){
            return;
        }
        for (int i = last; i < cand.length; i++){
//            这里这个if用于去除重复。。。。。在排序后，用一个简单的判断去除重复的情况
            if (i > last && cand[i] == cand[i - 1]){
                continue;
            }
            tmp.add(cand[i]);
            helper(cand, target - cand[i], i + 1);
            tmp.remove((Integer)cand[i]);
        }
    }
}
