package LeetcodeAll;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FourtySix1使用双向链表加map实现o1的LRU操作 {
    class LinkedNode {
        int key;
        int value;
        LinkedNode prev;
        LinkedNode next;
        public LinkedNode() {}
        public LinkedNode(int key,int value) {this.key = key;this.value = value;}
    }
    int capacity;
    int num;
    LinkedNode head;
    LinkedNode tail;
    Map<Integer,LinkedNode> map;
    public FourtySix1使用双向链表加map实现o1的LRU操作(int capacity) {
        this.capacity = capacity;
        num = 0;
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)){
            LinkedNode node =  map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = tail.prev;
            node.prev.next = node;
            node.next = tail;
            tail.prev = node;
            return node.value;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            LinkedNode node = map.get(key);
            node.value = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = tail.prev;
            node.prev.next = node;
            node.next = tail;
            tail.prev = node;
        }else{
            if (num == capacity){
                LinkedNode node = head.next;
                map.remove(node.key);
                head.next = node.next;
                node.next.prev = head;
                num--;
            }
            num++;
            LinkedNode node = new LinkedNode(key,value);
            node.prev = tail.prev;
            node.prev.next = node;
            node.next = tail;
            tail.prev = node;
            map.put(key,node);

        }
    }
}
