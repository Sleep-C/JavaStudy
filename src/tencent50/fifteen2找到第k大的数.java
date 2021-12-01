package tencent50;

public class fifteen2找到第k大的数 {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{2,1},2));
    }
    public static int findKthLargest(int[] nums, int k) {
        if (nums.length==0 || nums.length<k){
            return 0;
        }
        return nums[findK(nums,k,0,nums.length-1)];
    }
    public static int findK(int[] nums,int k,int i,int j){
        int m = (int) (Math.random()*(j-i)+i);
        int mm = nums[m];
        nums[m]=nums[i];
        int label=1;
        int j1=j;
        int i1=i;
        for (int g=0;g<j-i;g++){
            if (label==1){
                if (nums[j1]>mm){
                    nums[i1]=nums[j1];
                    i1++;
                    label=0;
                }else {
                    j1--;
                }
            }else {
                if (nums[i1]<mm){
                    nums[j1]=nums[i1];
                    j1--;
                    label=1;
                }else {
                    i1++;
                }
            }
        }
        nums[i1]=mm;
        if (i1==k-1){
            return i1;
        }else {
            if (i1>k-1){
                return findK(nums,k,i,i1-1);
            }else {
                return findK(nums,k,i1+1,j);
            }
        }
    }
}
