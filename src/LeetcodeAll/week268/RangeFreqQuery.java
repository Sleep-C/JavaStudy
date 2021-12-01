package LeetcodeAll.week268;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RangeFreqQuery {
    private Map<Integer, ArrayList<Integer[]>> map = new HashMap<>();
    public RangeFreqQuery(int[] arr) {
        int label = 0;
        for (int i = 0; i < arr.length; i++){
            if (i < arr.length - 1 && arr[i] == arr[i + 1]){
                continue;
            }
            if (map.containsKey(arr[i])){
                ArrayList<Integer[]> myArr = map.get(arr[i]);
                myArr.add(new Integer[]{label,i});
            }else {
                ArrayList<Integer[]> myArr = new ArrayList<>();
                myArr.add(new Integer[]{label,i});
                map.put(arr[i],myArr);
            }
            label = i + 1;
        }
    }

    public int query(int left, int right, int value) {
        if (!map.containsKey(value)){
            return 0;
        }
        int out = 0;
        ArrayList<Integer[]> myArr = map.get(value);
        Iterator iterator = myArr.iterator();
        while (iterator.hasNext()){
            Integer[] mid = (Integer[])iterator.next();
            if (mid[0] >= left && mid[1] <= right){
                out = out + mid[1] - mid[0] + 1;
            }else if (mid[0] <= left && mid[1] >= right){
                out = out + right - left + 1;
            }else if (left >= mid[0] && left <= mid[1]){
                out = out + mid[1] - left + 1;
            }else if(right >= mid[0] && right <= mid[1]){
                out = out + right - mid[0] +1;
            }
        }
        return out;
    }
}
