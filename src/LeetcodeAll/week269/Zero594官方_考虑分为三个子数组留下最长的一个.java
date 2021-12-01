package LeetcodeAll.week269;

public class Zero594官方_考虑分为三个子数组留下最长的一个 {
    public static void main(String[] args) {

    }
    public static int minimumDeletions(int[] nums) {
        if (nums.length == 1){
            return 1;
        }
        int max = 0;
        int min = 0;
        int out = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[max]){
                max = i;
            }
            if (nums[i] < nums[min]){
                min = i;
            }
        }
        int middle;
        if (max < min){
            middle = max;
            max = min;
            min = middle;
        }
        int i = 0;
        int j = nums.length - 1;
        if (min - i < j - max){
            out = out + min - i + 1;
            i = min + 1;
        }else {
            out = out + j - max + 1;
            j = max - 1;
            max = min;
        }
        if (max - i < j - max){
            out = out + max - i + 1;
        }else{
            out = out + j - max + 1;
        }
        return out;
    }
}
