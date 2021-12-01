package 设计模式.Abstract_Factory抽象工厂模式.factory;

public abstract class Factory {
    public static Factory getFactory(String classname) {
        Factory factory = null;
        try {
            factory = (Factory)Class.forName(classname).newInstance();//根据字符串，构造对应的具体工厂
        }catch (ClassNotFoundException e){
            System.out.println("没有找到" + classname + "类");
        }catch (Exception e){
            e.printStackTrace();
        }
        return factory;
    }
    public abstract Link createLink(String caption,String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title,String author);
}
