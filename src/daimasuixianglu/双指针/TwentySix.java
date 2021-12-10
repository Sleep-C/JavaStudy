package daimasuixianglu.双指针;

public class TwentySix {
    public static void main(String[] args) {

    }
    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if (i == nums.length - 1 || nums[i] != nums[i + 1]){
                nums[k] = nums[i];
                k++;
            }

        }
        return k;
    }
}
