package LeetcodeAll;

import AcWing.DoubleNodeList;
import tencent50.ListNode;

public class ToListNode {
    public static ListNode arrayToListNode(int[] arr){
        ListNode listNode = new ListNode(arr[0]);
        ListNode out = listNode;
        for (int i = 1; i<arr.length; i++){
            ListNode node = new ListNode(arr[i]);
            listNode.next = node;
            listNode = listNode.next;
        }
        return out;
    }
}
