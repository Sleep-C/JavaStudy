package daimasuixianglu.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 二叉树的统一前中后序迭代遍历 {

    //先序遍历
    public static List<Integer> TreeFirst(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if (root != null){
            stack.add(root);
        }
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node != null){
                stack.pop();

                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);

                stack.push(node);
                stack.push(null);
            }else {
                stack.pop();
                node = stack.pop();
                list.add(node.val);
            }
        }
        return list;
    }
    //中序遍历
    public static List<Integer> TreeMid(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if (root != null){
            stack.add(root);
        }
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node != null){
                stack.pop();

                if (node.right != null)stack.push(node.right);

                stack.push(node);
                stack.push(null);

                if (node.left != null)stack.push(node.left);
            }else {
                stack.pop();
                node = stack.pop();
                list.add(node.val);
            }
        }
        return list;
    }
    //后序遍历
    public static List<Integer> TreeLast(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        if (root != null){
            stack.add(root);
        }
        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (node != null){
                stack.pop();
                stack.push(node);
                stack.push(null);
                if (node.right != null)stack.push(node.right);
                if (node.left != null)stack.push(node.left);
            }else {
                stack.pop();
                node = stack.pop();
                list.add(node.val);
            }
        }
        return list;
    }
}
