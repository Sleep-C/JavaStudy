package daimasuixianglu.图;

import java.util.*;

public class Ten2做法与Seven2基本一致 {
    public static void main(String[] args) {
        Set<int[]> set = new HashSet<>();
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] record = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++){
            if (map.containsKey(prerequisites[i][1])){
                ArrayList list = map.get(prerequisites[i][1]);
                list.add(prerequisites[i][0]);
            }else {
                ArrayList<Integer> list = new ArrayList();
                list.add(prerequisites[i][0]);
                map.put(prerequisites[i][1],list);
            }
            record[prerequisites[i][0]]++;
        }
        int[] out = new int[numCourses];
        int k = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (record[i] == 0){
                queue.add(i);
                out[k] = i;
                k++;
            }
        }
        while (!queue.isEmpty()){
            int node = queue.poll();
            List<Integer> list = map.get(node);
            if (list == null){
                continue;
            }
            for (int i = 0; i < list.size(); i++){
                record[list.get(i)]--;
                if (record[list.get(i)] == 0){
                    queue.add(list.get(i));
                    out[k] = list.get(i);
                    k++;
                }
            }
        }
        for (int i = 0; i < numCourses; i++){
            if (record[i] > 0){
                return new int[]{};
            }
        }
        return out;
    }
}
