package 设计模式.prototype原型模式.framework;

public interface Product extends Cloneable{
    void use(String s);
    Product createClone();
}
