package LeetcodeAll.week269;

import java.util.ArrayList;
import java.util.List;

public class Eight593一次快排_想复杂了直接遍历小于target及等于target {
    public static void main(String[] args) {
        System.out.println(targetIndices(new int[]{1,2,5,2,3},5));
    }
    public static List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> out = new ArrayList<>();
        int label = -1;
        for (int i = 0; i < nums.length; i++){
            if (target == nums[i]){
                label = i;
                break;
            }
        }
        if (label == -1){
            return out;
        }
        int middle = nums[label];
        nums[label] = nums[0];
        nums[0] = middle;
        int i = 0;
        int j = nums.length - 1;
        for (; i != j; ){
            for ( ; i != j && nums[j] >= target; ){
                j--;
            }
            middle = nums[i];
            nums[i] = nums[j];
            nums[j] = middle;
            for ( ; i != j && nums[i] < target; ){
                i++;
            }
            middle = nums[i];
            nums[i] = nums[j];
            nums[j] = middle;
        }
        out.add(i);
        j++;
        for ( ; j < nums.length; j++){
            if (nums[j] == target){
                i++;
                out.add(i);
            }
        }
        return out;
    }
}
