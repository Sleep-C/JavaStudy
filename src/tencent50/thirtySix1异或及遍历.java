package tencent50;

public class thirtySix1异或及遍历 {
    public static void main(String[] args ){

    }
    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
