package 设计模式.Abstract_Factory抽象工厂模式.factory;

import java.util.ArrayList;

public abstract class Tray extends Item{
    protected ArrayList tray = new ArrayList();
    public Tray (String caption){
        super(caption);
    }
    public void add(Item item){
        tray.add(item);
    }
}
