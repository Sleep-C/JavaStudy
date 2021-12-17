package daimasuixianglu.图;

import java.util.*;

public class FiftyOne8深度优先或拓扑排序_一个值可能多次更新得来 {
    public static void main(String[] args) {
        System.out.println(loudAndRich(new int[][]{},new int[]{0}));
//        System.out.println(loudAndRich(new int[][]{{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}},new int[]{3,2,5,4,6,1,7,0}));
    }

    //官方解答，每次计算x后，找到比x小的点更新他们一次
    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; ++i) {
            g[i] = new ArrayList<Integer>();
        }
        for (int[] r : richer) {
            g[r[1]].add(r[0]);
        }

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < n; ++i) {
            dfs(i, quiet, g, ans);
        }
        return ans;
    }

    public static void dfs(int x, int[] quiet, List<Integer>[] g, int[] ans) {
        if (ans[x] != -1) {
            return;
        }
        ans[x] = x;
        for (int y : g[x]) {
            dfs(y, quiet, g, ans);
            if (quiet[ans[y]] < quiet[ans[x]]) {
                ans[x] = ans[y];
            }
        }
    }

//    public static int[] loudAndRich(int[][] richer, int[] quiet) {
//        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
//        int[] out = new int[quiet.length];
//        for (int i = 0; i < quiet.length; i++){
//            out[i] = -1;
//        }
//        for (int i = 0; i < richer.length; i++){
//            if (map.containsKey(richer[i][1])){
//                List<Integer> list = map.get(richer[i][1]);
//                list.add(richer[i][0]);
//            }else {
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(richer[i][0]);
//                map.put(richer[i][1],list);
//            }
//        }
//        for (int i = 0; i < quiet.length; i++){
//            if (out[i] != -1){
//                continue;
//            }
//            if (map.containsKey(i)){
//                List<Integer> list = map.get(i);
//                Stack<Integer> stack = new Stack();
//                Stack<Integer> stack2 = new Stack();
//                for (int j = 0; j < list.size(); j++){
//                    stack.push(list.get(j));
//                }
//                while(!stack.isEmpty()){
//                    int node = stack.pop();
//                    if (out[node] == -1){
//                        if (map.containsKey(node)){
//                            stack2.push(node);
//                            List<Integer> list2 = map.get(node);
//                            for (int j = 0; j < list2.size(); j++){
//                                stack.push(list2.get(j));
//                            }
//                        }else {
//                            out[node] = node;
//                        }
//                    }
//                }
//                while (!stack2.isEmpty()){
//                    int node = stack2.pop();
//                    List<Integer> list2 = map.get(node);
//                    out[node] = node;
//                    for(int j = 0; j < list2.size(); j++){
//                        if (quiet[out[node]] > quiet[out[list2.get(j)]]){
//                            out[node] = out[list2.get(j)];
//                        }
//                    }
//                }
//                List<Integer> list2 = map.get(i);
//                out[i] = i;
//                for (int j = 0; j < list2.size(); j++){
//                    if (quiet[out[i]] > quiet[out[list2.get(j)]]){
//                        out[i] = out[list2.get(j)];
//                    }
//                }
//            }else{
//                out[i] = i;
//            }
//        }
//        return out;
//    }
}
