package daimasuixianglu.二叉树;

import java.util.HashSet;
import java.util.Set;

public class Six1未完成_试试迭代用Map存储键值对能加速很多 {
    public static void main(String[] args) {

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode node = buildTree1(inorder,postorder,0,inorder.length - 1,0,postorder.length - 1);
        return node;
    }
    public TreeNode buildTree1(int[] inorder,int[] postorder,int in_left,int in_right,int post_left,int post_right){
        if (in_left > in_right || post_left > post_right){
            return null;
        }
        TreeNode node = new TreeNode(postorder[post_right]);
        int new_left = in_left;
        for (; new_left <= in_right; new_left++){
            if (inorder[new_left] == postorder[post_right]){
                node.left = buildTree1(inorder,postorder,in_left,new_left - 1,post_left, post_left + (new_left - 1 - in_left));
                node.right = buildTree1(inorder,postorder,new_left + 1,in_right,post_right - 1 - (in_right - new_left - 1),post_right - 1);
                break;
            }
        }
        return node;
    }
}
