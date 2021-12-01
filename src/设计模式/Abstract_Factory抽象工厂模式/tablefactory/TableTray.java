package 设计模式.Abstract_Factory抽象工厂模式.tablefactory;

import 设计模式.Abstract_Factory抽象工厂模式.factory.Tray;

public class TableTray extends Tray {

    public TableTray(String caption) {
        super(caption);
    }

    @Override
    public String makeHTML() {
        return null;
    }
}
