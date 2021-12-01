package 设计模式.Adapter适配器模式;

public class PrintBanner extends Banner implements Print {
    public  PrintBanner(String string){
        super(string);
    }
    @Override
    public void printWeak() {
        showWithParen();
    }

    @Override
    public void printStrong() {
        showWithAster();
    }
}
