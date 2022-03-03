package LeetcodeAll.week275;

public class Two没头绪 {
    public static void main(String[] args) {

    }
    public static int minSwaps(int[] nums) {
        int max = 0;
        int right = 0;
        int result = 0;
        int left = 0;
        int label = 0;
        if (nums[0] == 1 && nums[nums.length - 1] == 1){
            left = nums.length - 1;
            while(nums[left] == 1 && left != right){
                left--;
            }
            if (left == right){
                return 0;
            }
            left++;
            while(nums[right] == 1){
                right++;
            }
            right--;
            max = right + 1 + nums.length - left;
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                label++;
            }else{
                if (label > max){
                    max = label;
                    right = i - 1;
                }
                label = 0;
            }
        }
        if (label > max){
            max = label;
            right = nums.length - 1;
        }
        if (right - max >= -1){
            left = right - max + 1;
        }
        max = 0;
        int l = left - 1;
        int r = right + 1;
        while(r != l){
            if (nums[r] == 1){
                r++;
                l--;
                if (l < 0){
                    l = nums.length - 1;
                }

            }
        }
        return result;
    }
}
