package LeetcodeAll.week271;

public class Four动态规划未完成有bug {
    public static void main(String[] args) {
        System.out.println(maxTotalFruits(new int[][]{{200000,10000}},0,0));
    }
    public static int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int max = 0;
        int left = 0;
        int right = fruits.length - 1;
        for (; left < right - 1; ){
            int x = (left + right)/2;
            if (fruits[x][0] > startPos){
                right = x;
            }else if(fruits[x][0] < startPos){
                left = x;
            }else{
                left = x;
                right = x;
            }
        }
        if (k < Math.abs(startPos - fruits[left][0]) && k < Math.abs(fruits[right][0] - startPos)){
            return 0;
        }
        int myFruit = 0;
        int[] label = new int[fruits.length];
        for (;right < fruits.length && fruits[right][0] - startPos <= k;right++){
            myFruit += fruits[right][1];
            label[right] = 1;
            if ((double)(fruits[right][0] - startPos) < k/3.0){
                int mmm = mmm(fruits,label,right,fruits[right][0],k - fruits[right][0] + startPos,1);
                if (mmm + myFruit > max){
                    max = mmm + myFruit;
                }
            }

        }
        if (myFruit > max){
            max = myFruit;
        }
        myFruit = 0;
        label = new int[fruits.length];
        for (;left >= 0 && startPos - fruits[left][0]<= k; left--){
            myFruit += fruits[left][1];
            label[left] = 1;
            if ((double)(startPos - fruits[left][0]) < k/3.0){
                int mmm = mmm(fruits,label,left,fruits[left][0],k + fruits[left][0] - startPos,0);
                if (mmm + myFruit > max){
                    max = mmm + myFruit;
                }
            }

        }
        if (myFruit > max){
            max = myFruit;
        }
        return max;
    }
    public static int mmm(int[][] fruits,int[] label1,int lr,int startPos,int k,int posi){
        int out = 0;
        int[] label = label1.clone();
        if (posi == 0){
            for (;lr < fruits.length && fruits[lr][0] - startPos <= k;lr++){
                if (label[lr] == 0){
                    out += fruits[lr][1];
                }
            }
        }else{
            for (;lr >= 0 && startPos - fruits[lr][0]  <= k; lr--){
                if (label[lr] == 0){
                    out += fruits[lr][1];
                }
            }
        }
        return out;
    }
}
