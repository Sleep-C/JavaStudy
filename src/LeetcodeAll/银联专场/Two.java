package LeetcodeAll.银联专场;

import java.util.*;

public class Two {
    List<Map<Integer,Integer>> list;//每一个Map存储每个用户使用次数
    int[][] act;
PriorityQueue<Integer> priority = new PriorityQueue(new Comparator<Integer>(){
    @Override
    public int compare(Integer x,Integer y){
        return y - x;
    }
});

    Map<Integer, List<Integer>> pd = new HashMap<>();
    public Two() {
        list = new ArrayList<>();
        act = new int[1001][5];//第5列表示Map的序号

    }

    public void addActivity(int actId, int priceLimit, int discount, int number, int userLimit) {
        act[actId][0] = priceLimit;
        act[actId][1] = discount;
        act[actId][2] = number;
        act[actId][3] = userLimit;
        Map<Integer, Integer> map = new HashMap<>();
        list.add(map);
        act[actId][4] = list.size() - 1;
        priority.add(discount);
        if (pd.containsKey(discount)){
            List<Integer> list1 = pd.get(discount);
            list1.add(actId);
            list1.add(priceLimit);
        }else {
            List<Integer> list1 = new ArrayList<>();
            list1.add(actId);
            list1.add(priceLimit);
            pd.put(discount, list1);
        }
    }

    public void removeActivity(int actId) {
        List<Integer> list = pd.get(act[actId][1]);
        if (list.size() == 1){
            pd.remove(act[actId][1]);
            priority.remove(act[actId][1]);
        }else{
            list.remove((Object)act[actId][0]);
        }
        act[actId][0] = 0;
        act[actId][1] = 0;
        act[actId][2] = 0;
        act[actId][3] = 0;
        act[actId][4] = 0;
    }

    public int consume(int userId, int cost) {
        Iterator<Integer> iterator = priority.iterator();
        int disc;
        if (iterator.hasNext()){
            disc = iterator.next();
        }else {
            return cost;
        }
        while (disc > cost){
            if (iterator.hasNext()){
                disc = iterator.next();
            }
        }
        if (disc > cost){
            return cost;
        }
        return  0;
    }
}
