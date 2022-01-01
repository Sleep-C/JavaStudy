package daimasuixianglu.二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class TwentyTwo2什么都可二分查找二进制数的每一位表示左右未完成 {
    public static void main(String[] args) {

    }
    //官方方法，利用完全二叉树性质和二分查找
    public static int countNodes(TreeNode root) {
        TreeNode node = root;
        int depth = 0;
        while (node != null){
            depth++;
            node = node.left;
        }
        return  0;
    }
    //我的方法
//    public int countNodes(TreeNode root) {
//        int out = 0;
//        TreeNode node;
//        Queue<TreeNode> queue = new LinkedList<>();
//        if (root != null){
//            queue.add(root);
//        }
//        while(!queue.isEmpty()){
//            node = queue.poll();
//            out++;
//            if (node.left != null)queue.add(node.left);
//            if (node.right != null)queue.add(node.right);
//        }
//        return out;
//    }
}
