package LeetcodeAll.doubleWeek67;

import java.util.*;

public class One21 {
    public static void main(String[] args) {
        System.out.println(maximumDetonation(new int[][]{{2,1,3},{6,1,4}}));
    }
    public static int maximumDetonation(int[][] bombs) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < bombs.length; i++){
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < bombs.length; j++){
                if (i != j && (Math.pow(bombs[i][0] - bombs[j][0],2) + Math.pow(bombs[i][1] - bombs[j][1],2)) <= Math.pow(bombs[i][2],2)){
                    //这里用平方不开方的另一个好处是避免开方运算导致的精度问题影响开方结果
                    list.add(j);
                }
            }
            map.put(i,list);
        }
        int max = 0;
        for (int i = 0; i < bombs.length; i++){
            int num = 1;
            Set<Integer> set = new HashSet<>();
            set.add(i);
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            while (!queue.isEmpty()){
                List<Integer> list = map.get(queue.poll());
                for (int j = 0; j < list.size(); j++){
                    if (!set.contains(list.get(j))){
                        set.add(list.get(j));
                        queue.offer(list.get(j));
                        num++;
                    }
                }
            }
            if (num > max){
                max = num;
            }
        }
        return max;
    }
}
