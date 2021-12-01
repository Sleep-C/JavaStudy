package 设计模式.Bridge桥接模式.work9_1;

import 设计模式.Bridge桥接模式.StringDisplayImpl;

public class Main {
    public static void main(String[] args) {
        RandomDisplay d = new RandomDisplay(new StringDisplayImpl("Hello,China."));
        d.randomDiaplay(10);
    }
}
