package 设计模式.Abstract_Factory抽象工厂模式.tablefactory;

import 设计模式.Abstract_Factory抽象工厂模式.factory.Page;

public class TablePage extends Page {
    public TablePage(String title,String author){
        super(title,author);
    }

    @Override
    public String makeHTML() {
        return null;
    }
}
