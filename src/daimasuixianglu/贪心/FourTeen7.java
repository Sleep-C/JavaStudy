package daimasuixianglu.贪心;

import java.rmi.dgc.Lease;

public class FourTeen7 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,5,9},2));
    }
    public static int maxProfit(int[] prices, int fee) {
        if (prices.length == 1){
            return 0;
        }
        int left = 0;
        int right = 1;
        int result = 0;
        for (; right < prices.length; right++){
            if (prices[right] < prices[left]){
                left = right;
                continue;
            }
            if (prices[right] - prices[left] > fee){
                int label = right;
//                right++;
                while (true){
//                    prices[label] >= prices[right] && (right == prices.length - 1 ||

                    if (prices[label] < prices[right]){
                        label = right;
                    }
                    if (right == prices.length - 1){
                        result += (prices[label] - prices[left] - fee);
                        break;
                    }
                    if (prices[label] - prices[right] > fee){
                        result += (prices[label] - prices[left] - fee);
                        break;
                    }

                    right++;
                }
                left = right;
            }
        }
        return result;
    }
}
