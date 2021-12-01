package tencent50;

public class FortyNine {
    public static void main(String[] args ){
        System.out.println(generateMatrix(3));
    }
    public static int[][] generateMatrix(int n) {
        int[][] out = new int[n][n];
        int j=0;
        int k=0;
        int label=0;
        for (int i=1;i<n*n+1;i++){
            out[j][k]=i;
            switch (label){
                case 0:
                    if (k==n-1 || out[j][k+1]!=0){
                        j++;
                        label=1;
                    }else {
                        k++;
                    }
                    break;
                case 1:
                    if (j==n-1 || out[j+1][k]!=0){
                        k--;
                        label=2;
                    }else {
                        j++;
                    }
                    break;
                case 2:
                    if (k==0 || out[j][k-1]!=0){
                        j--;
                        label=3;
                    }else {
                        k--;
                    }
                    break;
                case 3:
                    if (out[j-1][k]!=0){
                        k++;
                        label=0;
                    }else {
                        j--;
                    }
                    break;
            }
        }
        return out;
    }
}
