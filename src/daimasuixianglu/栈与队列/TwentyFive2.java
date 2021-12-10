package daimasuixianglu.栈与队列;

import java.util.LinkedList;
import java.util.Queue;

public class TwentyFive2 {
    public static void main(String[] args) {
    }
}
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
    //????为什么不行？？？
    // Queue queue1;
    // Queue queue2;
    // public MyStack() {
    //     queue1 = new LinkedList();
    //     queue2 = new LinkedList();
    // }

    // public void push(int x) {
    //     queue2.offer(x);
    //     queue2.offer(queue1.peek());
    //     while (queue1.size() != 0){
    //         queue2.offer(queue1.poll());
    //     }
    //     while (queue2.size() != 0){
    //         queue1.offer(queue2.poll());
    //     }
    // }

    // public int pop() {
    //     return (int)queue1.poll();
    // }

    // public int top() {
    //     return (int)queue1.peek();
    // }

    // public boolean empty() {
    //     if (queue1.toArray().length != 0){
    //         return false;
    //     }else{
    //         return true;
    //     }
    // }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
