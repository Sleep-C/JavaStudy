package daimasuixianglu.二叉树;

import java.util.Stack;

public class NintyEight学习Double_MAX_VALUE以及改进我的中序遍历 {
    public static void main(String[] args) {

    }
    public static boolean isValidBST(TreeNode root) {
        //想偏了，简单的中序遍历，与前一个遍历值比较大小
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        double last = -Double.MAX_VALUE;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (node.val <= last){
                return false;
            }
            last = node.val;
            node = node.right;
        }
        return true;
    }
}
