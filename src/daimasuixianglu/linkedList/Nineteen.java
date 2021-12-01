package daimasuixianglu.linkedList;

public class Nineteen {
    public static void main(String[] args) {

    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode iter = head;
        int num = 0;
        while (iter != null){
            num++;
            iter = iter.next;
        }
        ListNode new_head = new ListNode();
        new_head.next = head;
        iter = new_head;
        for (int i = num; i > n; i--){
            iter = iter.next;
        }
        iter.next = iter.next.next;
        return new_head.next;
    }
}
