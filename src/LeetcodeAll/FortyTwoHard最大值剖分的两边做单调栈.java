package LeetcodeAll;

import java.util.Deque;
import java.util.LinkedList;

public class FortyTwoHard最大值剖分的两边做单调栈 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{2,0,2}));
    }
    public static int trap(int[] height) {
        int out = 0;
        int label = 0;
        for (int i = 1; i<height.length; i++){
            if (height[label] < height[i]){
                label = i;
            }
        }
        Deque<Integer> deque1 = new LinkedList();
        Deque<Integer> deque2 = new LinkedList();
        for (int i = label; i>=0; i--){
            for (;deque1.peek() != null;){
                if (height[deque1.peek()] <= height[i]){
                    deque1.poll();
                }else {
                    deque1.addFirst(i);
                    break;
                }
            }
            if (deque1.peek() == null){
                deque1.addFirst(i);
            }
        }
        for (int i = label; i < height.length; i++){
            for (; deque2.peek() != null;){
                if (height[deque2.peek()] <= height[i]){
                    deque2.poll();
                }else {
                    deque2.addFirst(i);
                    break;
                }
            }
            if (deque2.peek() == null){
                deque2.addFirst(i);
            }
        }
        int label2 = deque1.poll();
        while (deque1.peek() != null){
            int label3 = deque1.poll();
            for (int i = label2 + 1; i<label3; i++){
                out = out + height[label2] - height[i];
            }
            label2 = label3;
        }
        if (label2 != label){
            for (int i = label2 + 1; i<label; i++){
                out = out + height[label2] - height[i];
            }
        }
        label2 = deque2.poll();
        while (deque2.peek() != null){
            int label3 = deque2.poll();
            for (int i = label3 + 1; i < label2; i++){
                out = out + height[label2] - height[i];
            }
            label2 = label3;
        }
        if (label2 != label){
            for (int i = label + 1; i < label2; i++){
                out = out + height[label2] - height[i];
            }
        }
        return out;
    }
}
