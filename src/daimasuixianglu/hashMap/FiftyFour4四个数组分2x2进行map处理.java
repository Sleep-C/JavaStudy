package daimasuixianglu.hashMap;

import java.util.HashMap;
import java.util.Map;

public class FiftyFour4四个数组分2x2进行map处理 {
    public static void main(String[] args) {

    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map = new HashMap<>();
        int out = 0;
        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++){
                int mid = nums1[i] + nums2[j];
                if (map.containsKey(mid)){
                    map.put(mid,map.get(mid) + 1);
                }else{
                    map.put(mid,1);
                }
            }
        }
        for (int i = 0; i < nums3.length; i++){
            for (int j = 0; j < nums4.length; j++){
                int mid = -(nums3[i] + nums4[j]);
                if (map.containsKey(mid)){
                    out += map.get(mid);
                }
            }
        }
        return out;
    }
}
