package daimasuixianglu.动态规划;

import daimasuixianglu.二叉树.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ThirtySeven3重要思路针对选择与不选择做两个存储集合的动态规划 {
    public static void main(String[] args) {
        
    }
    //优化版本，每个节点只需要左右子节点的数据直接返回这些数据，不需要用map了
//    public int rob(TreeNode root) {
//        int[] rootStatus = dfs(root);
//        return Math.max(rootStatus[0], rootStatus[1]);
//    }
//
//    public int[] dfs(TreeNode node) {
//        if (node == null) {
//            return new int[]{0, 0};
//        }
//        int[] l = dfs(node.left);
//        int[] r = dfs(node.right);
//        int selected = node.val + l[1] + r[1];
//        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
//        return new int[]{selected, notSelected};
//    }


    static Map<TreeNode,Integer> f = new HashMap<>();//f表示选择节点n
    static Map<TreeNode,Integer> g = new HashMap<>();//g表示不选择节点n
    public static int rob(TreeNode root){
        dfs(root);
        return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0));
    }
    public static void dfs(TreeNode node){
        if (node == null){
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node,node.val + g.getOrDefault(node.left,0) + g.getOrDefault(node.right,0));
        g.put(node,Math.max(f.getOrDefault(node.left,0),g.getOrDefault(node.left,0)) + Math.max(f.getOrDefault(node.right,0),g.getOrDefault(node.right,0)));
    }
}
