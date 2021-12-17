package daimasuixianglu.图;

import java.util.*;

public class EightyFour6未看答案学习并查集且685 {
    public static void main(String[] args) {
        System.out.println(findRedundantConnection(new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1,5}}));
    }
    //只有一个环，可以依次移除所有度为1的节点，最后剩下的点必在环上，且如果在edges上一条边的两点同时在这个点集里，那么这条线段在这个环上
    public static int[] findRedundantConnection(int[][] edges) {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
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
        for (int i = edges.length - 1; i >= 0; i--){
            if (map.containsKey(edges[i][0]) && map.containsKey(edges[i][1])){
                return edges[i];
            }
        }
        return edges[0];
    }
//    public static int[] findRedundantConnection(int[][] edges) {
//        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
//        for (int i = 0; i < edges.length; i++){
//            if (map.containsKey(edges[i][0])){
//                ArrayList<Integer> list = map.get(edges[i][0]);
//                list.add(edges[i][1]);
//            }else{
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(edges[i][1]);
//                map.put(edges[i][0],list);
//            }
//            if (map.containsKey(edges[i][1])){
//                ArrayList<Integer> list = map.get(edges[i][1]);
//                list.add(edges[i][0]);
//            }else{
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(edges[i][0]);
//                map.put(edges[i][1],list);
//            }
//        }
//        Set<Integer> set = new HashSet<>();
//        List<Integer> record = new ArrayList<>();
//        Stack<Integer> stack = new Stack<>();
//        stack.add(0);
//        int circle = -1;
//        while(!stack.isEmpty()){
//            while (!map.containsKey(stack.peek())){
//                if (stack.peek() >= 0){
//                    stack.pop();
//                    if (stack.isEmpty()){
//                        break;
//                    }
//                    int num = stack.pop();
//                    for (int i = -1 ; i > num; i--){
//                        set.remove(record.get(record.size() + i));
//                        record.remove(record.size() + i);
//                    }
//                }else {
//                    int num = stack.pop();
//                    for (int i = -1 ; i > num; i--){
//                        set.remove(record.get(record.size() + i));
//                        record.remove(record.size() + i);
//                    }
//                }
//            }
//            int node = stack.pop();
//            if (!stack.isEmpty()){
//                int mid = stack.pop();
//                stack.add(mid - 1);
//            }
//            set.add(node);
//            record.add(node);
//
//            List list = map.get(node);
//            int label = 0;
//            for (int i = 0; i < list.size(); i++){
//                if ((int)list.get(i) != -1){
//                    label = 1;
//                    stack.add((int)list.get(i));
//                    stack.add(-1);
//                    List list2 = map.get((int)list.get(i));
//                    list2.remove((Integer)node);
//                    if (set.contains(list.get(i))){
//                        circle = (int)list.get(i);
//                        record.add(circle);
//                        break;
//                    }
//                    list.set(i,-1);
//                }
//            }
//            if (circle != -1){
//                break;
//            }
//            if (label == 1){
//                stack.pop();
//            }
//        }
//        int i = 0;
//        for (; record.get(i) != circle; i++){}
//        Set<int[]> circle_set = new HashSet<>();
//        circle_set.add(new int[]{record.get(i),record.get(i + 1)});
//        i++;
//        for( ; record.get(i) != circle; i++){
//            circle_set.add(new int[]{record.get(i),record.get(i + 1)});
//        }
//        for (int j = edges.length - 1; j >= 0; j--){
//            if (circle_set.contains(edges[i])){
//                return edges[i];
//            }
//        }
//        return edges[0];
//    }
}
