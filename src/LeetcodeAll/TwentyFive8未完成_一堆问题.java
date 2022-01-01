package LeetcodeAll;

public class TwentyFive8未完成_一堆问题 {
    public static void main(String[] args) {

    }
    public static int numFriendRequests(int[] ages) {
        int result = 0;
        fastSort(ages, 0, ages.length - 1);
        int label = ages.length - 1;
        for (int i = ages.length - 1; i > 0; i--){
            for (; label >= 0; label--){
                if (ages[label] <= 0.5*ages[i] + 7){
                    label++;
                    break;
                }
            }
            if (label < 0){
                label = 0;
            }
            if (label < i){
                result += (i - label);
            }
        }
        return result;
    }
    public static void fastSort(int[] ages,int left,int right){
        int mid = ages[left];
        int mid_left = left;
        int mid_right = right;
        while(mid_left < mid_right){
            while (ages[mid_right] > mid){
                mid_right--;
            }
            ages[mid_left] = ages[mid_right];
            mid_left++;
            if (mid_left >= mid_right){
                break;
            }
            while(ages[mid_left] < mid){
                mid_left++;
            }
            ages[mid_right] = ages[mid_left];
            mid_right--;
        }
        ages[mid_left] = mid;
        if (mid_left - left > 1){
            fastSort(ages,left,mid_left - 1);
        }
        if (right - mid_right > 1){
            fastSort(ages,mid_right + 1,right);
        }
    }
}
