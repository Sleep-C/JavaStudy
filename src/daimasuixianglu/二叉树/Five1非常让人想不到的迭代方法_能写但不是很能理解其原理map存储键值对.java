package daimasuixianglu.二叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Five1非常让人想不到的迭代方法_能写但不是很能理解其原理map存储键值对 {
    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{1,2},new int[]{2,1}));
    }
    //递归法用一个map存储键值对，速度会快很大
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int label1 = 1;
        int label2 = 0;
        while (label2 < inorder.length && label1 < preorder.length){
            while (label1 < preorder.length && stack.peek().val != inorder[label2]){
                TreeNode node = new TreeNode(preorder[label1]);
                stack.peek().left = node;
                stack.push(node);
                label1++;
            }
            TreeNode node1 = new TreeNode(preorder[0]);
            while (!stack.isEmpty() && stack.peek().val == inorder[label2]){
                label2++;
                node1 = stack.pop();
            }
            if (label1 >= preorder.length){
                break;
            }
            TreeNode node2 = new TreeNode(preorder[label1]);
            node1.right = node2;
            stack.push(node2);
            label1++;
        }
        return root;
    }
    //官方解答
//    public static TreeNode buildTree(int[] preorder, int[] inorder) {
//        if (preorder == null || preorder.length == 0) {
//            return null;
//        }
//        TreeNode root = new TreeNode(preorder[0]);
//        Deque<TreeNode> stack = new LinkedList<TreeNode>();
//        stack.push(root);
//        int inorderIndex = 0;
//        for (int i = 1; i < preorder.length; i++) {
//            int preorderVal = preorder[i];
//            TreeNode node = stack.peek();
//            if (node.val != inorder[inorderIndex]) {
//                node.left = new TreeNode(preorderVal);
//                stack.push(node.left);
//            } else {
//                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
//                    node = stack.pop();
//                    inorderIndex++;
//                }
//                node.right = new TreeNode(preorderVal);
//                stack.push(node.right);
//            }
//        }
//        return root;
//    }
}
