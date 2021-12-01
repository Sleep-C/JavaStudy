package 设计模式.Abstract_Factory抽象工厂模式.factory;

public abstract class Item {
    protected String caption;
    public Item(String caption){
        this.caption = caption;
    }
    public abstract String makeHTML();
}
