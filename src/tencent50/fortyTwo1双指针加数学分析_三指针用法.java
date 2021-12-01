package tencent50;

public class fortyTwo1双指针加数学分析_三指针用法 {
    public static void main(String[] args ){

    }
    public static ListNode detectCycle(ListNode head) {
        ListNode P1=head;//快指针
        ListNode P2=head;
        ListNode P3=head;
        if (P1==null){
            return null;
        }
        for (;;){
            if (P1.next==null){
                return null;
            }
            P1=P1.next;
            if (P1.next==null){
                return null;
            }
            P1=P1.next;
            P2=P2.next;
            if (P1==P2){
                break;
            }
        }
        for (;;){
            if (P2==P3){
                break;
            }
            P2=P2.next;
            P3=P3.next;
        }
        return P2;
    }
}
