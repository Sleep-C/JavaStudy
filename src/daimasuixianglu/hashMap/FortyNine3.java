package daimasuixianglu.hashMap;

import java.util.HashMap;
import java.util.Map;

public class FortyNine3 {
    public static void main(String[] args) {

    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        int n = 0;
        // int[] out = new int[];
        for (int i = 0; i < nums1.length; i++){
            map.put(nums1[i],1);
        }
        for (int i = 0; i<nums2.length; i++){
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) == 1){
                map.put(nums2[i],0);
                n++;
                map2.put(nums2[i],1);
            }
        }
        int[] out = new int[n];
        n = 0;
        for (Integer k:map2.keySet()){
            out[n] = k;
            n++;
        }
        return out;
    }
}
