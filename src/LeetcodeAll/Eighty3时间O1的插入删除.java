package LeetcodeAll;

import java.util.*;

public class Eighty3时间O1的插入删除 {
    List<Integer> arr;
    Map<Integer,Integer> map;
    Random random;
    public Eighty3时间O1的插入删除() {
        arr = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        int size = arr.size();
        arr.add(val);
        map.put(val,size);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int last = arr.get(arr.size() - 1);
        arr.set(index, last);
        map.put(last, index);
        arr.remove(arr.size() - 1);
        map.remove(val);
        return true;


    }

    public int getRandom() {
        int randomIndex = random.nextInt(arr.size());
        return arr.get(randomIndex);
    }

}
