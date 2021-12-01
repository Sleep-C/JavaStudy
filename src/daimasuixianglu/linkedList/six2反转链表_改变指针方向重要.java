package daimasuixianglu.linkedList;

public class six2反转链表_改变指针方向重要 {
    public static void main(String[] args) {

    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
