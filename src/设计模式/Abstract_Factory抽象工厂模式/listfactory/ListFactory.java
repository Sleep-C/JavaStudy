package 设计模式.Abstract_Factory抽象工厂模式.listfactory;

import 设计模式.Abstract_Factory抽象工厂模式.factory.Factory;
import 设计模式.Abstract_Factory抽象工厂模式.factory.Link;
import 设计模式.Abstract_Factory抽象工厂模式.factory.Page;
import 设计模式.Abstract_Factory抽象工厂模式.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption,url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title,author);
    }
}
