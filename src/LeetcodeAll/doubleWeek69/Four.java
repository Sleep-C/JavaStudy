package LeetcodeAll.doubleWeek69;

import java.util.HashSet;
import java.util.Set;

public class Four {
    public static void main(String[] args) {
        System.out.println(possibleToStamp(new int[][]{{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0}},4,3));
    }
    public static boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
//        if (){//可能邮票直接超出矩阵
//
//        }
        if (stampHeight > stampWidth){
            int mid = stampHeight;
            stampHeight = stampWidth;
            stampWidth = mid;
        }
        //从左上往右下，从右下往左上分别做一次，应该能全部覆盖
        for (int i = 0; i < grid.length - stampHeight; i++){
            for (int j = 0; j < grid[0].length - stampHeight; j++){
                if (grid[i][j] == 1 || grid[i][j] == -1) {
                    continue;
                }
                int label = 0;
                for (int low = i; ; low++){

                }
            }
        }
        for (int i = grid.length - 1; i >= stampHeight; i--){
            for (int j = grid[0].length - 1; j >= stampHeight; j--){
                if (grid[i][j] == 1 || grid[i][j] == -1){
                    continue;
                }

            }
        }

        return true;
    }
}
