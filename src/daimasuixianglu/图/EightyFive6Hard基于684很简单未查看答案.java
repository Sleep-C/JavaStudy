package daimasuixianglu.图;

import java.util.*;

public class EightyFive6Hard基于684很简单未查看答案 {
    public static void main(String[] args) {

    }
    public static int[] findRedundantDirectedConnection(int[][] edges) {
        int[] in_degree = new int[edges.length];
        int label = 0;
        for (int i = 0; i < edges.length; i++){
            in_degree[edges[i][1] - 1]++;
            if (in_degree[edges[i][1] - 1] == 2){
                label = edges[i][1];
            }
        }
        return findRedundantConnection(edges,label);
    }
    public static int[] findRedundantConnection(int[][] edges,int label) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i< edges.length; i++){
            int x = edges[i][0];
            if (map.containsKey(x)){
                ArrayList list = map.get(x);
                list.add(edges[i][1]);
            }else{
                ArrayList list = new ArrayList<>();
                list.add(edges[i][1]);
                map.put(x,list);
            }
            x = edges[i][1];
            if (map.containsKey(x)){
                ArrayList list = map.get(x);
                list.add(edges[i][0]);
            }else{
                ArrayList list = new ArrayList<>();
                list.add(edges[i][0]);
                map.put(x,list);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < edges.length; i++){
            if (map.get(i + 1).size() == 1){
                queue.offer(i + 1);
            }
        }
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = map.get(x).get(0);
            ArrayList<Integer> list = map.get(y);
            list.remove((Integer)x);
            if (list.size() == 1){
                queue.offer(y);
            }
            map.remove((Integer)x);
        }
        if (label == 0){
            for (int i = edges.length - 1; i >= 0; i--){
                if (map.containsKey(edges[i][0]) && map.containsKey(edges[i][1])){
                    return edges[i];
                }
            }

        }else{
            for (int i = edges.length - 1; i >= 0; i--){
                if (edges[i][1] == label && map.containsKey(edges[i][0]) && map.containsKey(edges[i][1])){
                    return edges[i];
                }
            }
        }
        return edges[0];
    }
}
