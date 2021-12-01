package tencent50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FiftyFour {
    public static void main(String[] args ){
        int[][] matrix=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;//行
        int n=matrix[0].length;//列
        List<Integer> out= new ArrayList<>(m*n);
        int j=0;
        int k=0;
        int label=0;
        for (int i=0;i<n*m;i++){
            out.add(matrix[j][k]);
            matrix[j][k]=0;
            switch (label){
                case 0:
                    if (k==n-1 || matrix[j][k+1]==0){
                        j++;
                        label=1;
                    }else {
                        k++;
                    }
                    break;
                case 1:
                    if (j==m-1 || matrix[j+1][k]==0){
                        k--;
                        label=2;
                    }else {
                        j++;
                    }
                    break;
                case 2:
                    if (k==0 || matrix[j][k-1]==0){
                        j--;
                        label=3;
                    }else {
                        k--;
                    }
                    break;
                case 3:
                    if (matrix[j-1][k]==0){
                        k++;
                        label=0;
                    }else {
                        j--;
                    }
                    break;
            }
        }

//        System.out.println(m);
//        System.out.println(n);
//        out.add(1);
//        out.add(2);
        return out;
    }
}
