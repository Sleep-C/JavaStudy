package JVM.studyJVM;

import java.util.concurrent.TimeUnit;

public class DeadTest01 {
    public static DeadTest01 VALUE = null;
    public static void isAlive(){
        if (VALUE != null){
            System.out.println("Alive in now!");
        }else {
            System.out.println("Dead in now!");
        }
    }

    public static void main(String[] args) {
        VALUE = new DeadTest01();

        VALUE = null;

        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        isAlive();
    }
}
