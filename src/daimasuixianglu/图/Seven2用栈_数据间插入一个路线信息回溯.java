package daimasuixianglu.图;

import java.util.*;

public class Seven2用栈_数据间插入一个路线信息回溯 {
    public static void main(String[] args) {
        System.out.println(canFinish(2,new int[][]{{1,0}}));
    }
    //有向图每次从图中摘取一个为入度为0的，再将对应出度减一，直到摘完。
    //官方做法，后面是我的做法
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int[] record = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++){
            if (prerequisites[i][0] == prerequisites[i][1]){
                return false;
            }
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
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++){
            if (record[i] == 0){
                queue.add(i);
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
                }
            }
        }
        for (int i = 0; i < numCourses; i++){
            if (record[i] > 0){
                return false;
            }
        }
        return true;
    }
    //方向理解反了，但这是有向图找环，不影响
    //考虑遍历的思想来深度遍历，维护路线链，找重复.
    //使用栈进行深度优先遍历，同时没练过节点中间插入一个信息，指示当某一个点到达底端并返回时set（路径）应该删除多少点
//    public static boolean canFinish(int numCourses, int[][] prerequisites) {
//        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
//        for (int i = 0; i < prerequisites.length; i++){
//            if (prerequisites[i][0] == prerequisites[i][1]){
//                return false;
//            }
//            if (map.containsKey(prerequisites[i][0])){
//                ArrayList list = map.get(prerequisites[i][0]);
//                list.add(prerequisites[i][1]);
//            }else {
//                ArrayList<Integer> list = new ArrayList();
//                list.add(prerequisites[i][1]);
//                map.put(prerequisites[i][0],list);
//            }
//        }
//        for (Integer key: map.keySet()){
//            Set<Integer> set = new HashSet<>();
//            List<Integer> record = new ArrayList<>();
//            Stack<Integer> stack = new Stack<>();
//            stack.add(key);
//            while (!stack.isEmpty()){
//                while (!map.containsKey(stack.peek())){
//                    if (stack.peek() >= 0){
//                        stack.pop();
//                        if (stack.isEmpty()){
//                            break;
//                        }
//                        int num = stack.pop();
//                        for (int i = -1 ; i > num; i--){
//                            set.remove(record.get(record.size() + i));
//                            record.remove(record.size() + i);
//                        }
//                    }else {
//                        int num = stack.pop();
//                        for (int i = -1 ; i > num; i--){
//                            set.remove(record.get(record.size() + i));
//                            record.remove(record.size() + i);
//                        }
//                    }
//
//                }
//                if (stack.isEmpty()){
//                    break;
//                }
//                int node = stack.pop();
//                if (!stack.isEmpty()){
//                    int mid = stack.pop();
//                    stack.add( mid -1 );
//                }
//                set.add(node);
//                record.add(node);
//                List list = map.get(node);
//                int label = 0;
//                for (int i = 0; i < list.size(); i++){
//                    if ((int)list.get(i) != -1){
//                        label = 1;
//                        stack.add((int)list.get(i));
//                        stack.add(-1);
//                        if (set.contains(list.get(i))){
//                            return false;
//                        }
//                        list.set(i,-1);
//                    }
//                }
//                if (label == 1){
//                    stack.pop();
//                }
//            }
//        }
//        return true;
//    }
}
