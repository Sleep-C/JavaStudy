package daimasuixianglu.栈与队列;

import java.util.Stack;

public class Fifty1学习string转int_转换一下数据类型速度提升一大半 {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }
    //转换一下数据类型，速度提升一大半，13ms-》5ms
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int x;
        int y;
        for (int i = 0; i < tokens.length; i++){
            switch(tokens[i]){
                case "+":
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(x + y);
                    break;
                case "-":
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y - x);
                    break;
                case "*":
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(x * y);
                    break;
                case "/":
                    x = stack.pop();
                    y = stack.pop();
                    stack.push(y / x);
                    break;
                default :
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
//    public static int evalRPN(String[] tokens) {
//        Stack stack = new Stack();
//        int x;
//        int y;
//        for (int i = 0; i < tokens.length; i++){
//            switch(tokens[i]){
//                case "+":
//                    x = Integer.parseInt((String)stack.pop());
//                    y = Integer.parseInt((String)stack.pop());
//                    stack.push((x + y) + "");
//                    break;
//                case "-":
//                    x = Integer.parseInt((String)stack.pop());
//                    y = Integer.parseInt((String)stack.pop());
//                    stack.push((y - x) + "");
//                    break;
//                case "*":
//                    x = Integer.parseInt((String)stack.pop());
//                    y = Integer.parseInt((String)stack.pop());
//                    stack.push((x * y) + "");
//                    break;
//                case "/":
//                    x = Integer.parseInt((String)stack.pop());
//                    y = Integer.parseInt((String)stack.pop());
//                    stack.push((y / x) + "");
//                    break;
//                default :
//                    stack.push(tokens[i]);
//            }
//        }
//        return Integer.parseInt((String)stack.pop());
//    }
}
