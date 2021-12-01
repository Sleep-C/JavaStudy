package daimasuixianglu.linkedList;

public class 面试题02_07参考答案为数学分析法_多用数学分析 {
    public static void main(String[] args) {

    }
    //a为相交前的节点数，c为相交点到链表结尾的节点数。
    //若相交，链表A： a+c, 链表B : b+c
    //a+c+b+c = b+c+a+c 。则会在公共处c起点相遇
    //若不相交，a+b = b+a 。因此相遇处是NULL
//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        ListNode h1 = headA;
//        ListNode h2 = headB;
//        while(h1 != h2){
//            h1 = h1 == null ? headB : h1.next;
//            h2 = h2 == null ? headA : h2.next;
//        }
//        return h1;
//    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int numA = 0;
        int numB = 0;
        ListNode mid = headA;
        while (mid != null){
            numA++;
            mid = mid.next;
        }
        mid = headB;
        while (mid != null){
            mid = mid.next;
            numB++;
        }
        mid = headA;
        ListNode midB = headB;
        if (numA > numB){
            for (int i = 0; i < numA - numB; i++){
                mid = mid.next;
            }
        }else{
            for (int i = 0; i<numB - numA; i++){
                midB = midB.next;
            }
        }
        while(mid != null){
            if (midB == mid){
                return mid;
            }
            mid = mid.next;
            midB = midB.next;
        }
        return null;
    }
}
