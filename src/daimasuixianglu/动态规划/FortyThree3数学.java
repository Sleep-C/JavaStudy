package daimasuixianglu.动态规划;

public class FortyThree3数学 {
    public static void main(String[] args) {
        System.out.println(integerBreak(20));
    }
    public static int integerBreak(int n) {
        int[] arr = new int[n + 1];
        if (n < 6){
            switch(n){
                case 2:
                    return 1;
                case 3:
                    return 2;
                case 4:
                    return 4;
                case 5:
                    return 6;
            }
        }
        arr[2] = 1;
        arr[3] = 2;
        arr[4] = 4;
        arr[5] = 6;
        arr[6] = 9;
        for (int i = 7; i <= n; i++){
            for (int j = 1; j < 4; j++){
                if (arr[i] < arr[i - j]*j){
                    arr[i] = arr[i - j]*j;
                }
            }
        }
        return arr[n];
    }
}
