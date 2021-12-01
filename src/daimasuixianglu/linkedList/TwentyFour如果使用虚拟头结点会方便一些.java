package daimasuixianglu.linkedList;

public class TwentyFour如果使用虚拟头结点会方便一些 {
    public static void main(String[] args) {

    }
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode out = head.next;
        while(curr != null){
            if (curr.next == null){
                break;
            }
            if (prev != null){
                prev.next = curr.next;
                curr.next = curr.next.next;
                prev.next.next = curr;
            }else{
                prev = curr.next;
                curr.next = curr.next.next;
                prev.next = curr;
            }

            prev = curr;
            curr = curr.next;
        }
        return out;
    }
}
