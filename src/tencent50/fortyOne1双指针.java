package tencent50;

public class fortyOne1双指针 {
    public static void main(String[] args ){

    }
    public static boolean hasCycle(ListNode head) {
        ListNode i=head;
        ListNode j=head;
        int label=0;
        if (j.next!=null){
            j=j.next;
        }else {
            return false;
        }
        for (;;){
            if (j.next!=null){
                j=j.next;
            }else {
                return false;
            }
            if (i==j){
                return true;
            }
            if (j.next!=null){
                j=j.next;
            }else {
                return false;
            }
            if (i==j){
                return true;
            }
            i=i.next;
        }
    }
}
