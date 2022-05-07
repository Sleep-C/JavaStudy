package JVM.studyJVM;

import java.util.concurrent.TimeUnit;

public class JavaMemoryModel {
    //保证变量对所有线程可见性,不保证原子性
//    static volatile int num = 0;
    static int num = 0;
    public static void main(String[] args){
        new Thread(()->{
            while (num == 0){

            }
        },"线程A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        num = 1;

    }
}
