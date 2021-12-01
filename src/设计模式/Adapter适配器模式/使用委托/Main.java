package 设计模式.Adapter适配器模式.使用委托;

import 设计模式.Adapter适配器模式.Print;
import 设计模式.Adapter适配器模式.PrintBanner;

public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
