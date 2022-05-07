package daimasuixianglu.动态规划;

public class NinetySix数学_找规律 {
    public static void main(String[] args) {

    }
    public int numTrees(int n) {
        // if (n == 1){
        //     return 1;
        // }
        int[] arr = new int[n];
        arr[0] = 1;
        // arr[1] = 2;
        for (int i = 1; i < n; i++){
            arr[i] += 2*arr[i - 1];
            for(int j = 1; j < i; j++){
                arr[i] += arr[j - 1]*arr[i - j - 1];
            }
        }
        return arr[n - 1];
    }
}
