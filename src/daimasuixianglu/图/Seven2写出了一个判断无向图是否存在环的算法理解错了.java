package daimasuixianglu.图;

import java.util.*;

public class Seven2写出了一个判断无向图是否存在环的算法理解错了 {
    public static void main(String[] args) {
        System.out.println(canFinish(8,new int[][]{{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}}));
    }
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++){
            if (prerequisites[i][0] == prerequisites[i][1]){
                return false;
            }
            if (map.containsKey(prerequisites[i][0])){
                ArrayList list = map.get(prerequisites[i][0]);
                list.add(prerequisites[i][1]);
            }else {
                ArrayList<Integer> list = new ArrayList();
                list.add(prerequisites[i][1]);
                map.put(prerequisites[i][0],list);
            }
        }
        for (Integer key: map.keySet()){
            Set<Integer> set = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(key);
            while (!queue.isEmpty()){
                while (!map.containsKey(queue.peek())){
                    queue.poll();
                    if (queue.isEmpty()){
                        break;
                    }
                }
                if (queue.isEmpty()){
                    break;
                }
                set.add(queue.peek());
                List list = map.get(queue.peek());
                for (int i = 0; i < list.size(); i++){
                    if ((int)list.get(i) != -1){
                        queue.add((int)list.get(i));
                        if (set.contains(list.get(i))){
                            return false;
                        }
                        list.set(i,-1);
                    }
                }
                queue.poll();
            }
        }
        return true;
    }
}
