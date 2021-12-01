package daimasuixianglu.linkedList;

public class three2注意在判断next是否为空前先要判断当前节点是否为空 {
    public static void main(String[] args) {

    }
    public static ListNode removeElements(ListNode head, int val) {
        for (;head!=null && head.val==val;){
            head=head.next;
        }
        ListNode p1=head;
        for (;p1!=null && p1.next!=null;){
            for (;p1.next!=null && p1.next.val==val;){
                if (p1.next!=null){
                    p1.next=p1.next.next;
                }else{
                    p1.next=null;
                }
            }
            p1=p1.next;
        }
        return head;
    }
}
