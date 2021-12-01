package 设计模式.Bridge桥接模式;

public class CountDisplay extends Display{
    public CountDisplay(DisplayImpl impl) {
        super(impl);
    }
    public void multiDisplay(int times){
        open();
        for (int i = 0; i<times; i++){
            print();
        }
        close();
    }
}
