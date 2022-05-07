package daimasuixianglu.贪心;

public class ThirtyFive1Hard不用初始化 {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,3,2,2,1}));
    }
    //未能辨识出评分相等的情况
    //这里对评分相等的情况其实只会影响初始化的代码
    public static int candy(int[] ratings) {
        if (ratings.length == 1){
            return 1;
        }
        if (ratings.length == 2){
            if (ratings[0] == ratings[1]){
                return 2;
            }else {
                return 3;
            }
        }
        //arr从左到右
        int[] arr = new int[ratings.length];
        int[] arr2 = new int[ratings.length];
        for (int i = 1; i < ratings.length - 1; i++){
            if (ratings[i - 1] >= ratings[i] && ratings[i] <= ratings[i + 1]){
                arr[i] = 1;
                arr2[i] = 1;
            }
        }
        if (ratings[0] <= ratings[1]){
            arr[0] = 1;
            arr2[0] = 1;
        }
        if (ratings.length > 2 && ratings[ratings.length - 1] <= ratings[ratings.length - 2]){
            arr[ratings.length - 1] = 1;
            arr2[ratings.length - 1] = 1;
        }
        for (int i = 1; i < ratings.length; i++){
            if (arr[i - 1] != 0 && ratings[i - 1] < ratings[i]){
                arr[i] = arr[i - 1] + 1;
            }
        }
        for (int i = ratings.length- 2; i >= 0; i--){
            if (arr2[i + 1] != 0 && ratings[i + 1] < ratings[i]){
                arr2[i] = arr2[i + 1] + 1;
            }
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] >= arr2[i]){
                result += arr[i];
            }else {
                result += arr2[i];
            }
        }
        return result;
    }
}
