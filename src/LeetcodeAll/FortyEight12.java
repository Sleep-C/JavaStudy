package LeetcodeAll;

public class FortyEight12 {
    public static void main(String[] args) {

    }
    public static int numberOfSubarrays(int[] nums, int k) {
        int[] label = new int[nums.length];
        int j = -1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] % 2 == 1){
                j++;
                label[j] = i;
            }
        }
        if (k > j + 1){
            return 0;
        }
        int out = 0;
        int m1 = 1;
        int m2 = k;
        if (k == j + 1){
            return (label[0] + 1)*(nums.length - label[j]);
        }else{
            out = out + (label[0] + 1)*(label[k] - label[k-1]);
            out = out + (nums.length - label[j])*(label[j - k + 1] - label[j - k]);
        }

        for (; m2 < j;){
            out = out + (label[m1] - label[m1 - 1])*(label[m2 + 1] - label[m2]);
            m2++;
            m1++;
        }
        return out;
    }
}
