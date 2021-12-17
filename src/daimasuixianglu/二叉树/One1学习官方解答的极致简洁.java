package daimasuixianglu.二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class One1学习官方解答的极致简洁 {
    public static void main(String[] args) {

    }
    //两个官方解答极致简洁
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }
    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }


//    public static boolean isSymmetric(TreeNode root) {
//        return check(root, root);
//    }
//    public static boolean check(TreeNode u, TreeNode v) {
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(u);
//        q.offer(v);
//        while (!q.isEmpty()) {
//            u = q.poll();
//            v = q.poll();
//            if (u == null && v == null) {
//                continue;
//            }
//            if ((u == null || v == null) || (u.val != v.val)) {
//                return false;
//            }
//
//            q.offer(u.left);
//            q.offer(v.right);
//
//            q.offer(u.right);
//            q.offer(v.left);
//        }
//        return true;
//    }


//    public static boolean isSymmetric(TreeNode root) {
//        if (root == null || (root.left == null && root.right ==null)){
//            return true;
//        }
//        if ((root.left == null && root.right != null) || (root.left != null && root.right == null) || (root.left != null && root.left.val != root.right.val)){
//            return false;
//        }
//        TreeNode left = root.left;
//        TreeNode right = root.right;
//        Stack<TreeNode> left_stack = new Stack();
//        Stack<TreeNode> right_stack = new Stack();
//        left_stack.push(left);
//        right_stack.push(right);
//        while(!left_stack.isEmpty() && !right_stack.isEmpty()){
//            left = left_stack.pop();
//            right = right_stack.pop();
//
//            if ((left.left == null && right.right != null) || (left.left != null && right.right == null) || (left.left != null && left.left.val != right.right.val)){
//                return false;
//            }
//            if ((left.right == null && right.left != null) || (left.right != null && right.left == null) || (left.right != null && left.right.val != right.left.val)){
//                return false;
//            }
//            if (left.left != null){
//                left_stack.push(left.left);
//                right_stack.push(right.right);
//            }
//            if (left.right != null){
//                left_stack.push(left.right);
//                right_stack.push(right.left);
//            }
//        }
//        if (!left_stack.isEmpty() || !right_stack.isEmpty()){
//            return false;
//        }
//
//        return true;
//    }
}
