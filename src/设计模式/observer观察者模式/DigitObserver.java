package 设计模式.observer观察者模式;

public class DigitObserver implements Observer{

    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitGenerator:" + generator.getNumber());
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){

        }
    }
}
