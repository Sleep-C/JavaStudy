package tencent50;

public class ThirtyThree {
    public static void main(String[] args ){
        int[] a={4,5,6,7,0,1,2};
        System.out.println(search(a,0));
    }
    public static int search(int[] nums, int target) {
        int n=nums.length;
        if (nums[n-1]==target){
            return n-1;
        }else if (nums[n-1]<target){
            for (int i=0;i<=n-1;i++){
                if (nums[i]==target){
                    return i;
                }
                if (i>0 && nums[i]<nums[i-1]){
                    break;
                }
            }
        }else {
            for (int i=n-1;i>=0;i--){
                if (nums[i]==target){
                    return i;
                }
                if(i<n-1 && nums[i]>nums[i+1]){
                    break;
                }
            }
        }
        return -1;
    }
}
