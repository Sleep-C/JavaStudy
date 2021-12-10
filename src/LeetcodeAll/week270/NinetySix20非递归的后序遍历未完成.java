package LeetcodeAll.week270;

import tencent50.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NinetySix20非递归的后序遍历未完成 {
    public static void main(String[] args) {

    }
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
        public String getDirections(TreeNode root, int startValue, int destValue) {
            List<Integer> startList = new ArrayList<>();
            List<Integer> destList = new ArrayList<>();
            int label1 = 0;
            int label2 = 0;
            TreeNode node = null;
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.addFirst(root);
            while(deque.peek() != null){

                TreeNode tree = deque.poll();

            }
            return "";
        }

}
