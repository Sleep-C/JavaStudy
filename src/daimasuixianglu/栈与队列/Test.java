package daimasuixianglu.栈与队列;

import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++){
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if (stack.peek() == s.charAt(i)){
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }
        }
        Stack stack2 = new Stack();
        while(!stack.isEmpty()){
            stack2.push(stack.pop());
        }
        String out = "";
        while(!stack2.isEmpty()){
            out += stack2.pop();
        }
        return out;
    }
}
