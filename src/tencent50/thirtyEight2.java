package tencent50;

public class thirtyEight2 {
    public static void main(String[] args) {

    }
    public static int[] productExceptSelf(int[] nums) {
        int[] out=new int[nums.length];
        int m=1;
        for (int i=0;i<nums.length;i++){
            out[i]=m;
            m=m*nums[i];
        }
        m=1;
        for(int i=nums.length-1;i>=0;i--){
            out[i]=out[i]*m;
            m=m*nums[i];
        }
        return out;
    }
}
