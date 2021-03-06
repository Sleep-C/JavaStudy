package 设计模式.prototype原型模式;

import 设计模式.prototype原型模式.framework.Product;

public class UnderlinePen implements Product {
    private char ulchar;
    public UnderlinePen(char ulchar){
        this.ulchar = ulchar;
    }
    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        System.out.println("\"" + s + "\"");
        System.out.print(" ");
        for (int i = 0;i<length;i++){
            System.out.print(ulchar);
        }
        System.out.println("");
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product)clone();//此除用法，没见过***
//            p = (Product)this.clone();//此处省略了this,效果一样
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return p;
    }
}
