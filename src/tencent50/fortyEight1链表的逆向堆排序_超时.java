package tencent50;

public class fortyEight1链表的逆向堆排序_超时 {
    public static void main(String[] args){
        ListNode p4=new ListNode(3);
        ListNode p3=new ListNode(1,p4);
        ListNode p2=new ListNode(2,p3);
        ListNode p1=new ListNode(4,p2);
        System.out.println(sortList(p1).val);
    }
    //时间n*log(n)，空间1,
    public static ListNode sortList(ListNode head) {
        ListNode P1=head;
        ListNode P2=head;
        int min=0;
        if (head==null){
            return head;
        }
        int length=1;
        for (;P1.next!=null;){
            length++;
            P1=P1.next;
        }
        for (;length>1;){
            heapsort(P2,length);
            length--;
            min=P1.val;
            P1.val=P2.val;
            P2.val=min;
            P2=P2.next;
        }
        return head;
    }
    public static void heapsort(ListNode p,int length){
        ListNode p2=p;
        ListNode p3=p;
        ListNode p4=p.next;
        int min;
        if (length%2==0){
            for (int j=0;j<length/2;j++){
                p2=p2.next;
            }
            if (p2.val>p3.val){
                min=p2.val;
                p2.val=p3.val;
                p3.val=min;
            }
            p2=p2.next;
            p3=p3.next;
            p4=p4.next;
            for (int j=0;j<(length-1)/2;j++){
                if (p3.val>p4.val){
                    if (p4.val<p2.val){
                        min=p4.val;
                        p4.val=p2.val;
                        p2.val=min;
                    }
                }else {
                    if (p3.val<p2.val){
                        min=p3.val;
                        p3.val=p2.val;
                        p2.val=min;
                    }
                }
                if (p2.next!=null){
                    p2=p2.next;
                }
                p3=p3.next.next;
                p4=p4.next.next;
            }
        }else {
            for (int j=0;j<length/2+1;j++){
                p2=p2.next;
            }
            for (int j=0;j<length/2;j++){
                if (p3.val>p4.val){
                    if (p4.val<p2.val){
                        min=p4.val;
                        p4.val=p2.val;
                        p2.val=min;
                    }
                }else {
                    if (p3.val<p2.val){
                        min=p3.val;
                        p3.val=p2.val;
                        p2.val=min;
                    }
                }
                if (p2.next!=null){
                    p2=p2.next;
                }
                p3=p3.next.next;
                p4=p4.next.next;
            }

        }
    }
}
