package 设计模式.Abstract_Factory抽象工厂模式.factory;

public abstract class Link extends Item{
    protected String url;
    public Link(String caption,String url){
        super(caption);
        this.url = url;
    }
}
