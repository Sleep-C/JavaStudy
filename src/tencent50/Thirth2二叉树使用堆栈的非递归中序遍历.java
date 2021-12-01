package tencent50;

import java.util.ArrayDeque;
import java.util.Deque;

public class Thirth2二叉树使用堆栈的非递归中序遍历 {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(1,null,n1);
        TreeNode n4 = new TreeNode(3,n3,n2);
        System.out.println(kthSmallest(n4,1));
    }
    //堆栈先进后出，队列先进先出
    public static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
//    public static int kthSmallest(TreeNode root, int k) {
//        return LDR(root,k,0)[1];
//    }
//    public static int[] LDR(TreeNode root,int k,int m){
//        if (root.left!=null){
//            int[] re=LDR(root.left,k,m);
//            if (re[1]!=0){
//                return re;
//            }
//            m=re[0];
//        }
//        m++;
//        if (m==k){
//            return new int[]{m,root.val};
//        }
//        if (root.right!=null){
//            int[] re=LDR(root.right,k,m);
//            if (re[1]!=0){
//                return re;
//            }
//            m=re[0];
//        }
//        return new int[]{m,0};
//    }
}

