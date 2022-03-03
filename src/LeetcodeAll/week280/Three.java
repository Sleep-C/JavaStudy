package LeetcodeAll.week280;

import java.util.Arrays;

public class Three {
    public static void main(String[] args) {
        System.out.println(minimumRemoval(new int[]{8,9,5,4,7,8,2}));
    }
    public static long minimumRemoval(int[] beans) {
        long result = 0;
        Arrays.sort(beans);
        for (int i = 0; i < beans.length; i++){
            if (result < (long)beans[i]*(long)(beans.length - i)){
                result = (long)beans[i]*(long)(beans.length - i);
            }
        }
        result = -result;
        for (int i = 0; i < beans.length; i++){
            result += (long)beans[i];
        }
        return result;
    }
}
