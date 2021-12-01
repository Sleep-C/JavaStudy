package LeetcodeAll.week267;

import tencent50.ListNode;

public class Four207情况没想完_审题错误_补救先遍历获取长度 {
    public static void main(String[] args) {//1,1,0,6,5错误
//        ListNode n10 = new ListNode(4);
//        ListNode n9 = new ListNode(8,n10);
//        ListNode n8 = new ListNode(3,n9);
//        ListNode n7 = new ListNode(7,n8);
//        ListNode n6 = new ListNode(1,n7);
//        ListNode n5 = new ListNode(9,n6);
//        ListNode n4 = new ListNode(3,n5);
//        ListNode n3 = new ListNode(6,n4);
//        ListNode n2 = new ListNode(2,n3);
//        ListNode n1 = new ListNode(5,n2);

        ListNode n5 = new ListNode(5);
        ListNode n4 = new ListNode(6,n5);
        ListNode n3 = new ListNode(0,n4);
        ListNode n2 = new ListNode(1,n3);
        ListNode n1 = new ListNode(1,n2);
        ListNode n = n1;
        for (;n.next!=null;){
            System.out.print(n.val + "+");
            n = n.next;
        }
        System.out.println(n.val + "+");
        n = reverseEvenLengthGroups(n1);
        for (;n.next!=null;){
            System.out.print(n.val + "-");
            n = n.next;
        }
        System.out.println(n.val + "-");
    }
    //考虑奇数位置因为缺的原因而有偶数个数1，1，0，6，5。65对于的区间本应该有三个但实际没有第6个数字，所以65也是偶数
    public static ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode out = head;
        ListNode node = head;
        for (int i = 1;; i++){
            if (i%2 == 0){
                changeList(node,i);
                head = node.next;
            }
            for (int j = 0; j<i; j++){
                if (head.next == null){
                    break;
                }
                node = head;
                head = head.next;
            }
            if (head.next == null){
                break;
            }

        }
        return out;
    }
    public static void changeList(ListNode node,int num){
        ListNode last_node = node;
        if (node.next != null && node.next.next != null){
            ListNode node1 = node.next;
            ListNode node2 = node1.next;
            int m = 0;
            for (;node2!=null && m<num;){
                node1.next = node;

                node = node1;
                node1 = node2;
                if (node2 != null){
                    node2 = node2.next;
                }
                m++;
            }
            // if (m == num){
            if (node2 == null && m == num){
                last_node.next.next = node1;
                last_node.next = node;
            }else if (node2 == null && m < num){
                node1.next = node;
                last_node.next.next = null;
                last_node.next = node1;
            } else{
                node2 = last_node.next;
                last_node.next = node;
                node2.next = node1;
            }
        }

    }
}
