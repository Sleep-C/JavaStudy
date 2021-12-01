package LeetcodeAll.week269;

public class Nine593数据过多可能超过整数范围 {
    public static void main(String[] args) {
        System.out.println(getAverages(new int[]{7,4,3,9,1,8,5,2,6},3).toString());
    }
    public static int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        long middle = 0;
        if (k >= (len/2 + len%2)){
            k = len/2 + len%2;
        }
        int[] out = new int[len];
        for (int i = 0; i < len; i++){
            out[i] = -1;
            out[len - i - 1] = -1;
        }
        if (k == len/2 + len%2){
            return out;
        }
        for (int i = 0; i < 2*k + 1; i++){
            middle += nums[i];
        }
//        middle = middle/(2*k + 1);
        int i = 0;
        int j = 2*k + 1;
        out[(i + j - 1)/2] = (int)(middle/(2*k + 1));
        for ( ; j < len; ){
            middle = middle - nums[i] + nums[j];
            i++;
            j++;
            out[(i + j - 1)/2] = (int)(middle/(2*k + 1));
        }
        return out;
    }
}
