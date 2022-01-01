package daimasuixianglu.回溯;

import java.util.*;

public class Test写在方法外的变量如果要在static方法中调用必须在变量前加static {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,7,6,3,5,1},9).toString());
    }
    static LinkedList<Integer> tmp = new LinkedList<>();
    static List<List<Integer>> result = new LinkedList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0);
        return result;
    }
    public static void helper(int[] cand,int target,int last){
        if (target == 0){
            result.add(new ArrayList<>(tmp));
            return;
        }
        if (target < 0){
            return;
        }
//        或者先排序后如下
//        if (target < cand[last]){
//            return;
//        }
        for (int i = last; i < cand.length; i++){
            tmp.push(cand[i]);
            helper(cand, target - cand[i], i);
            tmp.pop();
        }
    }
}
