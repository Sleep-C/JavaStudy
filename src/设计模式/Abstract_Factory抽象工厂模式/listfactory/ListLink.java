package 设计模式.Abstract_Factory抽象工厂模式.listfactory;

import 设计模式.Abstract_Factory抽象工厂模式.factory.Link;

public class ListLink extends Link {
    public ListLink(String caption,String url){
        super(caption,url);
    }
    @Override
    public String makeHTML() {
        return "   <li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}
