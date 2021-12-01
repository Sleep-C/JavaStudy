package daimasuixianglu.array;

public class nine2滑动窗口 {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(6,new int[]{10,2,3}));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int all = 0;
        int label=-1;
        for (int i=0;i<nums.length;i++){
            all=all+nums[i];
            if (all>=target){
                label=i;
                break;
            }
        }
        if (label==-1){
            return 0;
        }
        int label2=label+1;
        for (int i=0;i<nums.length;i++){
            all = all - nums[i];
            if (all>=target){
                if (label2>label-i){
                    label2=label-i;
                }
            }
            for (int j=label+1;j<nums.length;j++){
                if (all>=target){
                    if (label2>label-i){
                        label2=label-i;
                    }
                    break;
                }
                all=all+nums[j];
                label++;
            }
            if (all<target){
                return label2;
            }
        }
        return label2;
    }
}
