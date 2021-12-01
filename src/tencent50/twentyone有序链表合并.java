package tencent50;

public class twentyone有序链表合并 {
    public static void main(String[] args) {

    }
    //标准答案
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }
//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if(l1==null && l2==null){
//            return l1;
//        }
//        ListNode out=new ListNode();
//        ListNode out1=out;
//        ListNode out2=new ListNode();
//        int label=0;
//        if(l1==null){
//            label++;
//        }
//        if(l2==null){
//            label++;
//        }
//        for (;label!=2;){
//            if (l2!=null && (l1==null || l1.val>l2.val)){
//                out.val=l2.val;
//                l2=l2.next;
//                if (l2==null){
//                    label++;
//                }
//
//            }else{
//                out.val=l1.val;
//                l1=l1.next;
//                if (l1==null){
//                    label++;
//                }
//            }
//            ListNode l=new ListNode();
//            out.next=l;
//            out2=out;
//            out=out.next;
//        }
//        out2.next=null;
//
//        return out1;
//    }
}
