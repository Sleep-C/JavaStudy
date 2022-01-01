package daimasuixianglu.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FiftySeven2使用StringBuffer比String快10倍空间也少 {
    public static void main(String[] args) {

    }
    //StringBuffer
    public List<String> result = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null){
            StringBuffer path = new StringBuffer();
            path.append(root.val);
            if (root.left != null){
                Depth(root.left,new StringBuffer(path));
            }else if (root.right == null){
                result.add(path.toString());
            }
            if (root.right != null){
                Depth(root.right, new StringBuffer(path));
            }
        }
        return result;
    }
    public void Depth(TreeNode node,StringBuffer path1){
        path1.append("->");
        path1.append(node.val);
        if (node.left != null){
            Depth(node.left, new StringBuffer(path1));
        }else if (node.right == null){
            result.add(path1.toString());
        }
        if (node.right != null){
            Depth(node.right, new StringBuffer(path1));
        }
    }
    //迭代法，用stringbuffer速度应该不错
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> result = new ArrayList<>();
//        if (root == null)
//            return result;
//        Stack<Object> stack = new Stack<>();
//        // 节点和路径同时入栈
//        stack.push(root);
//        stack.push(root.val + "");
//        while (!stack.isEmpty()) {
//            // 节点和路径同时出栈
//            String path = (String) stack.pop();
//            TreeNode node = (TreeNode) stack.pop();
//            // 若找到叶子节点
//            if (node.left == null && node.right == null) {
//                result.add(path);
//            }
//            //右子节点不为空
//            if (node.right != null) {
//                stack.push(node.right);
//                stack.push(path + "->" + node.right.val);
//            }
//            //左子节点不为空
//            if (node.left != null) {
//                stack.push(node.left);
//                stack.push(path + "->" + node.left.val);
//            }
//        }
//        return result;
//    }

    //String
//    public List<String> result = new ArrayList<>();
//    public List<String> binaryTreePaths(TreeNode root) {
//        if (root != null){
//            String path = root.val + "";
//            if (root.left != null){
//                Depth(root.left,path);
//            }else if (root.right == null){
//                result.add(path);
//            }
//            if (root.right != null){
//                Depth(root.right, path);
//            }
//        }
//        return result;
//    }
//    public void Depth(TreeNode node,String path){
//        path = path + "->" + node.val;
//        if (node.left != null){
//            Depth(node.left, path);
//        }else if (node.right == null){
//            result.add(path);
//        }
//        if (node.right != null){
//            Depth(node.right, path);
//        }
//    }
}
