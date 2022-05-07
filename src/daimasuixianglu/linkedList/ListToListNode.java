package daimasuixianglu.linkedList;

import java.util.List;

public class ListToListNode {
    public static ListNode ListToNode(int[] list){
        ListNode head = new ListNode(list[0]);
        ListNode node = head;
        for (int i = 1; i < list.length; i++){
            ListNode n = new ListNode(list[i]);
            node.next = n;
            node = node.next;
        }
        return head;
    }
}
