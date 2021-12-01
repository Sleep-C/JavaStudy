package 设计模式.Abstract_Factory抽象工厂模式.tablefactory;

import 设计模式.Abstract_Factory抽象工厂模式.factory.Link;

public class TableLink extends Link {

    public TableLink(String caption, String url) {
        super(caption, url);
    }

    @Override
    public String makeHTML() {
        return null;
    }
}
