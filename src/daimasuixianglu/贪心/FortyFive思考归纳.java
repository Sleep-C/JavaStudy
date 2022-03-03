package daimasuixianglu.贪心;

public class FortyFive思考归纳 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
    }
    public static int jump(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int left = 0;
        int right = nums[0];
        int result = 1;
        while(right < nums.length - 1){
            result++;
            int mid = right;
            for (; left <= right; left++){
                if (left + nums[left] > mid){
                    mid = left + nums[left];
                }
            }
            right = mid;
        }
        return result;
    }
}
