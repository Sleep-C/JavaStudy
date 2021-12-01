package LeetcodeAll;

public class twentyThree1Hard未完成 {
    public static void main(String[] args ){
        int[] prices=new int[]{6,1,3,2,4,7};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices){
        int[] num = maxProfit2(prices,0,prices.length);
        int[] num1 = maxProfit2(prices,0,num[1]);
        int[] num2 = maxProfit2(prices,num[2]+1,prices.length);
        if (num1[0]==0 && num2[0]==0){
            return maxProfit3(prices,num[1],num[2]);
        }else {
            if (num1[0]>num2[0]){
                return num[0]+num1[0];
            }else {
                return num[0]+num2[0];
            }
        }
    }
    public static int maxProfit3(int[] prices,int m,int n){
        //只有一次买卖的可以增加买卖数,也可以考虑在num之间插入一次买卖所得结果与原本的比较
        return 0;
    }
    public static int[] maxProfit2(int[] prices,int m,int n){
        //考虑只有一次买卖的可以增加买卖数
        if (m>=n){
            return new int[]{0,0,0};
        }
        int min=prices[m];
        int max=0;
        int ni=m;
        int mini=0;
        int maxi=0;
        for (int i=m;i<n;i++){
            if (min>prices[i]){
                min=prices[i];
                ni=i;
            }
            if (max<(prices[i]-min)){
                max=prices[i]-min;
                mini=ni;
                maxi=i;
            }
        }
        return new int[]{max,mini,maxi};
    }
}
