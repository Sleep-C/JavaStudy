package tencent50;

public class sixtyOne空空空 {
    public static void main(String[] args ){
        ListNode l1= new ListNode(1);
        ListNode l2= new ListNode(2,l1);
        ListNode l3= new ListNode(3,l2);
        ListNode l4= new ListNode(4,l3);
        ListNode l5= new ListNode(5,l4);
        ListNode l6=new ListNode();
//        ListNode l2= new ListNode(2,l1);
        System.out.println(rotateRight(l6,0).val);
    }
    public static ListNode rotateRight(ListNode head, int k) {
//        if (head!=null){
//            return head;
//        }
        int num=0;
        ListNode head2=head;
        for (;head.next!=null;num++){
            head=head.next;
        }
        num++;
        head.next=head2;
        k=k%num;
//        int n1=k;
        int n2=num-k;
        head=head2;
        for (int i=0;i<n2-1;i++){
            head=head.next;
        }
        head2=head.next;
        head.next=null;
//        System.out.println(head2.val);
        return head2;
    }
}

