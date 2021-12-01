package 设计模式.prototype原型模式.framework;

import java.util.HashMap;

public class Manager {
    private HashMap showcase = new HashMap();
    public void register(String name,Product proto){
        showcase.put(name,proto);
    }
    public Product create(String protoname){
        Product p = (Product)showcase.get(protoname);
        return p.createClone();
    }
}
