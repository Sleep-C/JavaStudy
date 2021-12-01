package 设计模式.Bridge桥接模式.work9_3巧妙;

import 设计模式.Bridge桥接模式.CountDisplay;
import 设计模式.Bridge桥接模式.DisplayImpl;

public class IncreaseDisplay extends CountDisplay {
    private int step;
    public IncreaseDisplay(DisplayImpl impl,int step) {
        super(impl);
        this.step = step;
    }
    public void increaseDisplay(int level){
        int count = 0;
        for (int i = 0; i<level; i++){
            multiDisplay(count);
            count += step;
        }
    }
}
