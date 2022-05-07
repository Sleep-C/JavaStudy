package daimasuixianglu.动态规划;

public class TwentyThree1Hard完成188 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        if (prices.length == 1){
            return 0;
        }
        int[] arr = new int[prices.length];
        int[] arr2 = new int[prices.length];
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++){
            if (min <= prices[i]){
                if (prices[i] - min > arr[i - 1]){
                    arr[i] = prices[i] - min;
                    if (arr[i] > max){
                        max = arr[i];
                    }
                }else {
                    arr[i] = arr[i - 1];
                }
            }else {
                arr[i] = arr[i - 1];
                min = prices[i];
            }
        }
        //倒过来算一次差值
        min = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--){
            if (min >= prices[i]){
                if (min - prices[i] > arr2[i + 1]){
                    arr2[i] = min - prices[i];
                }else {
                    arr2[i] = arr2[i + 1];
                }
            }else {
                arr2[i] = arr2[i + 1];
                min = prices[i];
            }
        }
        for (int i = 1; i < arr.length - 2; i++){
            if (max < arr[i] + arr2[i + 1]){
                max = arr2[i + 1] + arr[i];
            }
        }
        return max;
    }
}
