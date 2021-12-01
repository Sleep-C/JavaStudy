package 设计模式.Factory_Method工厂模式.work4_2;

import 设计模式.Factory_Method工厂模式.work4_2.framework.Factory;
import 设计模式.Factory_Method工厂模式.work4_2.idcard.IDCardFactory;
import 设计模式.Factory_Method工厂模式.work4_2.framework.Product;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("小明");
        Product card2 = factory.create("小红");
        Product card3 = factory.create("小刚");
        card1.use();
        card2.use();
        card3.use();
    }
}
