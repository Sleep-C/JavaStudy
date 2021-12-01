package 设计模式.prototype原型模式;

import 设计模式.prototype原型模式.framework.Product;

public class MessageBox implements Product {
    private char decochar;
    public MessageBox(char decochar){
        this.decochar = decochar;
    }
    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        for (int i = 0;i < length + 4;i++){
            System.out.print(decochar);
        }
        System.out.println("");
        System.out.println(decochar + " " + s + " " + decochar);
        for (int i = 0;i < length +4; i++){
            System.out.print(decochar);
        }
        System.out.println("");
    }

    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product)clone(); //此次用法，没见过***
//            p = (Product)this.clone();//此处省略了this,效果一样
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return p;
    }
}
