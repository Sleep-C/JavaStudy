package daimasuixianglu.二叉树;

public class ListToTreeNode {
    public static TreeNode ListToFullTreeNode(int[] arr){
        TreeNode[] treeList = new TreeNode[arr.length];
        for (int i = arr.length - 1; i >= 0; i--){
            if (i > arr.length/2 - 1){
                treeList[i] = new TreeNode(arr[i]);
            }else if (i < arr.length/2 - 1){
                treeList[i] = new TreeNode(arr[i],treeList[(i + 1)*2 - 1],treeList[(i + 1)*2]);
            }else {
                if (arr.length%2 == 0){
                    treeList[i] = new TreeNode(arr[i],treeList[(i + 1)*2 - 1],null);
                }else {
                    treeList[i] = new TreeNode(arr[i],treeList[(i + 1)*2 - 1],treeList[(i + 1)*2]);
                }
            }
        }


        return treeList[0];
    }
}
