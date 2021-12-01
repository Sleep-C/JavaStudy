package tencent50;

public class sixtyTwo {
    public static void main(String[] args ){
        int[] a={-1,2,1,-4};
        System.out.println(uniquePaths(1,3));
    }
    public static int uniquePaths(int m, int n) {
        if (m>n){
            int x=m;
            m=n;
            n=x;
        }
        int[][] arr=new int[m][n];
        for (int i=0;i<n;i++){
            arr[0][i]=1;
        }
        for (int i=1;i<m;i++){
            int x=0;
            for (int j=0;j<n;j++){
                x=x+arr[i-1][j];
                arr[i][j]=x;
            }
        }
        return arr[m-1][n-1];
    }
}
