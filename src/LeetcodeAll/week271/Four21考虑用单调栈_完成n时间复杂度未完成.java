package LeetcodeAll.week271;

public class Four21考虑用单调栈_完成n时间复杂度未完成 {
    public static void main(String[] args) {

    }
    public static long subArrayRanges(int[] nums) {
        long out = 0;
        for (int i = 0; i < nums.length - 1; i++){
            int min = nums[i];
            int max = nums[i];
            for (int j = i + 1; j < nums.length; j++){
                if (min > nums[j]){
                    min = nums[j];
                }
                if (max < nums[j]){
                    max = nums[j];
                }
                out = out + (max - min);
            }
        }
        return out;
    }
}
