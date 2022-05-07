package LeetcodeAll.银联专场;

import daimasuixianglu.linkedList.ListToListNode;
import daimasuixianglu.linkedList.ListNode;

import java.util.*;

public class One {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue(new Comparator<Integer>(){

            @Override
            public int compare(Integer x,Integer y){
                return y - x;
            }
        });
        priorityQueue.add(3);
        priorityQueue.add(1);
        priorityQueue.add(4);
        priorityQueue.add(5);
        Iterator<Integer> iterator = priorityQueue.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        map.remove((Object)1);
        int[] arr = new int[]{1,2,2,3,1};
        ListNode head = ListToListNode.ListToNode(arr);
        System.out.println(isPalindrome(head));
    }
    //{1,2,2,3,1}报错
    public static boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null){
            list.add(node.val);
            node = node.next;
        }
        node = head;
        int i = list.size() - 1;
        while (i >= 0 && node.val == list.get(i)){
            node = node.next;
            i--;
        }
        if (i < 0){
            return true;
        }
        int n = i;
        head = node;
        node = node.next;
        while (i >= list.size()/2 && node.val == list.get(i)){
            node = node.next;
            i--;
        }
        if (i < list.size()/2){
            return true;
        }
        i = n - 1;
        node = head;
        while (i >= list.size()/2 && node.val == list.get(i)){
            node = node.next;
            i--;
        }
        if (i < list.size()/2){
            return true;
        }
        return false;
    }
}
