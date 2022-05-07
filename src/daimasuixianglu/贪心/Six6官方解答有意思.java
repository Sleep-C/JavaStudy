package daimasuixianglu.贪心;

import java.util.*;

public class Six6官方解答有意思 {
    public static void main(String[] args) {
        System.out.println(reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}}));
    }
    //官方解答研究一下
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else {
                    return person2[1] - person1[1];
                }
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
//    public static int[][] reconstructQueue(int[][] people){
//        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        int[][] result = new int[people.length][2];
//        for (int i = 0; i < result.length; i++){
//            result[i][0] = -1;
//        }
//        for (int i = 0; i < people.length; i++){
//            if (!map.containsKey(people[i][0])){
//                PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>();
//                priorityQueue1.add(people[i][1]);
//                map.put(people[i][0],priorityQueue1);
//                priorityQueue.add(people[i][0]);
//            }else {
//                PriorityQueue<Integer> priorityQueue1 = map.get(people[i][0]);
//                priorityQueue1.add(people[i][1]);
//            }
//        }
//        int[] list = new int[priorityQueue.size()];
//        int label = 0;
//        while (priorityQueue.size() > 0){
//            list[label] = priorityQueue.poll();
//            label++;
//        }
//        for (int i = 0; i <list.length; i++){
//            PriorityQueue<Integer> priorityQueue2 = map.get(list[i]);
//            int mid = 0;
//            int k = 0;
//            while (priorityQueue2.size() > 0){
//                int j = priorityQueue2.poll();
//                for (; k < result.length; k++){
//                    if (result[k][0] != -1){
//                        continue;
//                    }
//                    if (mid == j){
//                        result[k][0] = list[i];
//                        result[k][1] = j;
//                        mid++;
//                        break;
//                    }
//                    mid++;
//                }
//            }
//        }
//        return result;
//    }
}
