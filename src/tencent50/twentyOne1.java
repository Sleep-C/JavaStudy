package tencent50;

public class twentyOne1 {
    public static void main(String[] args ){
        int[] prices=new int[]{7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices){//最优解法
        int min=prices[0];
        int max=0;
        for (int i=0;i<prices.length;i++){
            if (min>prices[i]){
                min=prices[i];
            }
            if (max<(prices[i]-min)){
                max=prices[i]-min;
            }
        }
        return max;

    }
//    public static int maxProfit(int[] prices) {
//        return maxProfit2(prices,prices.length-1,0);
//    }
//    public static int maxProfit2(int[] prices,int m,int n){
//        int max = n;
//        int min = n;
//        for (int i=n;i<=m;i++){
//            if (prices[max]<prices[i]){
//                max=i;
//            }
//            if (prices[min]>prices[i]){
//                min=i;
//            }
//        }
//        if (min<=max){
//            return prices[max]-prices[min];
//        }else {
//            int maxP2=maxProfit2(prices,min,max+1);
//            int min2=n;
//            for (int i=n+1;i<max;i++){
//                if (prices[min2]>prices[i]){
//                    min2=i;
//                }
//            }
//            int max2=min;
//            for (int i=min+1;i<=m;i++){
//                if (prices[max2]<prices[i]){
//                    max2=i;
//                }
//            }
//            int maxP1 = prices[max]-prices[min2];
//            int maxP3 = prices[max2]-prices[min];
//            if (maxP2<maxP3){
//                maxP2=maxP3;
//            }
//            if (maxP1<maxP2){
//                maxP1=maxP2;
//            }
//            return maxP1;
//        }
//    }
}
