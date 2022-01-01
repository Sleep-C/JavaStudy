package daimasuixianglu.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Two1学习递归与非递归的层序遍历 {
    public static void main(String[] args) {

    }
    //非递归重要
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null)return out;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> itemList = new ArrayList<>();
            int len = queue.size();
            while(len > 0){
                TreeNode tmpNode = queue.poll();
                itemList.add(tmpNode.val);
                if (tmpNode.left != null)queue.offer(tmpNode.left);
                if (tmpNode.right != null)queue.offer(tmpNode.right);
                len--;
            }
            out.add(itemList);
        }
        return out;
    }
    //递归
//    public List<List<Integer>> out = new ArrayList<>();
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        changeOut(root,0);
//        return out;
//    }
//    public void changeOut(TreeNode node,int deep){
//        if (node == null){
//            return;
//        }
//        deep++;
//        if (out.size() < deep){
//            List<Integer> list = new ArrayList<>();
//            out.add(list);
//        }
//        out.get(deep - 1).add(node.val);
//        changeOut(node.left,deep);
//        changeOut(node.right,deep);
//    }

}
