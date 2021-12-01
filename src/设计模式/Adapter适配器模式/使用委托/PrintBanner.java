package 设计模式.Adapter适配器模式.使用委托;

public class PrintBanner extends Print{
    private Banner banner;
    public PrintBanner(String string){
        this.banner = new Banner(string);
    }
    @Override
    public void printWeak() {
        banner.showWithParen();
    }

    @Override
    public void printStrong() {
        banner.showWithAster();
    }
}
