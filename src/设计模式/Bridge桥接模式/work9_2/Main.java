package 设计模式.Bridge桥接模式.work9_2;

import 设计模式.Bridge桥接模式.CountDisplay;

public class Main {
    public static void main(String[] args) {
        CountDisplay d = new CountDisplay(new FileDisplayImpl(".\\src\\设计模式\\Bridge桥接模式\\work9_2\\star.txt"));
        d.multiDisplay(3);
    }
}
