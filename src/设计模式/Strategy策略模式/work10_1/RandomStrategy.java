package 设计模式.Strategy策略模式.work10_1;

import 设计模式.Strategy策略模式.Hand;
import 设计模式.Strategy策略模式.Strategy;

import java.util.Random;

public class RandomStrategy implements Strategy {
    private Random random;
    public RandomStrategy(int seed){
        random = new Random(seed);
    }
    @Override
    public Hand nextHand() {
        return Hand.getHand(random.nextInt(3));
    }

    @Override
    public void study(boolean win) {

    }
}
