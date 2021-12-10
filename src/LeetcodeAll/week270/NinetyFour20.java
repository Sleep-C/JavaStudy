package LeetcodeAll.week270;

import java.util.*;

public class NinetyFour20 {
    public static void main(String[] args) {

    }
    public int[] findEvenNumbers(int[] digits) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < digits.length; i++){
            if (map.containsKey(digits[i])){
                map.put(digits[i],map.get(digits[i]) + 1);
            }else{
                map.put(digits[i],1);
            }
        }
        for (int i = 1; i < 10; i++){
            if (!map.containsKey(i)){
                continue;
            }
            for (int j = 0; j < 10; j++){
                if (!map.containsKey(j) || (i == j && map.get(j) == 1)){
                    continue;
                }
                for (int k = 0; k < 9; k = k + 2){
                    if (!map.containsKey(k) || (i != j && (map.get(k) == 1 && (i == k || j == k))) || (i == j && j == k && map.get(k) < 3)){
                        continue;
                    }
                    list.add(i*100 + j*10 + k);
                }
            }
        }
        int[] arr1 = list.stream().mapToInt(Integer::valueOf).toArray();
        return arr1;
    }
}
