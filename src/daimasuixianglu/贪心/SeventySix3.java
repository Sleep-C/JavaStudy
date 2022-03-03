package daimasuixianglu.贪心;

public class SeventySix3 {
    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1,7,4,9,2,5}));
    }
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length == 1){
            return 1;
        }
        if (nums.length == 2 && nums[0] == nums [1]){
            return 1;
        }else if (nums.length == 2 && nums[0] != nums [1]){
            return 2;
        }
        int result = 1;
        int label = 0;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (last != nums[i]){
                if (last > nums[i]){
                    label = 0;
                }else {
                    label = 1;
                }
                last = i;
                result++;
                break;
            }
        }
        for (int i = last + 1; i < nums.length; i++){
            if (label == 0){
                if (nums[i] > nums[last]) {
                    result++;
                    label = 1;
                }
                last = i;
            }else {
                if (nums[i] < nums[last]){
                    label = 0;
                    result++;
                }
                last = i;
            }
        }
        return result;
    }
}
