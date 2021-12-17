package LeetcodeAll.doubleWeek66;

public class Seven208最好不要复制粘贴_一定注意在复制粘贴代码时需要更改的地方 {
    public static void main(String[] args) {
        System.out.println(minCost(new int[]{1,0},new int[]{2,3},new int[]{5,4,3},new int[]{8,2,6,7}));
    }
    public static int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int out = 0;
        if (startPos[0] < homePos[0]){
            for ( ; startPos[0] < homePos[0]; ){
                startPos[0]++;
                out += rowCosts[startPos[0]];
            }
        }
        if (startPos[0] > homePos[0]){
            for ( ; startPos[0] > homePos[0]; ){
                startPos[0]--;
                out += rowCosts[startPos[0]];
            }
        }
        if (startPos[1] < homePos[1]){
            for ( ; startPos[1] < homePos[1]; ){
                startPos[1]++;
                out += colCosts[startPos[1]];
            }
        }
        if (startPos[1] > homePos[1]){
            for ( ; startPos[1] > homePos[1]; ){
                startPos[1]--;
                out += colCosts[startPos[1]];
            }
        }
        return out;
    }
}
