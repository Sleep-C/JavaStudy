package 设计模式.Bridge桥接模式.work9_1;

import 设计模式.Bridge桥接模式.CountDisplay;
import 设计模式.Bridge桥接模式.DisplayImpl;

import java.util.Random;

public class RandomDisplay extends CountDisplay {
    private Random random = new Random();
    public RandomDisplay(DisplayImpl impl) {
        super(impl);
    }
    public void randomDiaplay(int times){
        multiDisplay(random.nextInt(times));
    }
}
