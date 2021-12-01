package LeetcodeAll.doubelWeek65;

import java.util.HashMap;
import java.util.Map;

public class zero207排序后查找未完成 {
    public static void main(String[] args) {

    }
    public static int[] maximumBeauty(int[][] items, int[] queries) {
        Map<Integer,Integer> item = new HashMap<>();
        for (int i = 0 ; i<items.length; i++){
            if (item.containsKey(items[i][0])){
                if (item.get(items[0])<items[i][1]){
                    item.put(items[i][0],items[i][1]);
                }
            }else {
                item.put(items[i][0],items[i][1]);
            }
        }
        return new int[]{0};
    }
}
