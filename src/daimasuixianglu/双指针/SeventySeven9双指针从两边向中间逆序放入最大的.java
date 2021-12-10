package daimasuixianglu.双指针;

public class SeventySeven9双指针从两边向中间逆序放入最大的 {
    public static void main(String[] args) {
        System.out.println(sortedSquares(new int[]{-4,-1,0,3,10}));
    }

//    public int[] sortedSquares(int[] nums) {
//        int n = nums.length;
//        int[] ans = new int[n];
//        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
//            if (nums[i] * nums[i] > nums[j] * nums[j]) {
//                ans[pos] = nums[i] * nums[i];
//                ++i;
//            } else {
//                ans[pos] = nums[j] * nums[j];
//                --j;
//            }
//            --pos;
//        }
//        return ans;
//    }

    public static int[] sortedSquares(int[] nums) {
        int[] out = new int[nums.length];
        int i = 0;
        for (;i < nums.length;i++){
            if (nums[i] >= 0){
                break;
            }
        }
        if (i == nums.length){
            i--;
        }
        int j;
        if (i > 0){
            j = i - 1;
        }else{
            for (int k = 0; k < nums.length; k++){
                out[k] = nums[k]*nums[k];
            }
            return out;
        }
        int k = 0;
        for (; k < nums.length; k++){
            if (nums[i] > -nums[j]){
                out[k] = nums[j]*nums[j];
                j--;
                if (j < 0){
                    k++;
                    break;
                }
            }else{
                out[k] = nums[i]*nums[i];
                i++;
                if (i == nums.length){
                    k++;
                    break;
                }
            }
        }
        if (j < 0){
            for (; k < nums.length && i < nums.length; k++){
                out[k] = nums[i]*nums[i];
                i++;
            }
        }else{
            for(; k < nums.length; k++){
                out[k] = nums[j]*nums[j];
                j--;
            }
        }
        return out;
    }
}
