package LeetcodeAll.week272;

public class Three {
    public static void main(String[] args) {

    }
    public long getDescentPeriods(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1;){
            int j = i + 1;
            for (; j < prices.length; j++){
                if (prices[j - 1] - prices[j] != 1){
                    break;
                }
            }
            for (int k = i + 1; k < j; k++){
                result += (k - i);
            }
            i = j;
        }
        result += prices.length;
        return result;
    }
}
