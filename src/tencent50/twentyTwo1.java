package tencent50;

public class twentyTwo1 {
    public static void main(String[] args ){
        int[] prices=new int[]{1,9,6,9,1,7,1,1,5,9};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int min=-1;
        int num=0;
        if (prices.length<2){
            return 0;
        }
        for (int i=1;i<prices.length;i++){
            if (prices[i-1]<prices[i]){
                if (min==-1){
                    min=i-1;
                }
            }else if (prices[i-1]>=prices[i]){
                if (min!=-1){
                    num=num+prices[i-1]-prices[min];
                    min=-1;
                }
            }
        }
        if (prices[prices.length-2]<prices[prices.length-1]){
            num=num+prices[prices.length-1]-prices[min];
        }
        return num;
    }
}
