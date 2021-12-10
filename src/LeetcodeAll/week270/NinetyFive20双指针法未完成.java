package LeetcodeAll.week270;

import tencent50.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class NinetyFive20双指针法未完成 {
    public static void main(String[] args) {

    }
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        int num = 1;
        ListNode mid = head;
        while(mid.next != null){
            mid = mid.next;
            num++;
        }
        mid = head;
        num = num/2;
        for (int i = 0; i < num - 1; i++){
            head = head.next;
        }
        head.next = head.next.next;
        return mid;
    }
}
