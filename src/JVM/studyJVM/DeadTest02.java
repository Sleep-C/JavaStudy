package JVM.studyJVM;

import java.util.concurrent.TimeUnit;

public class DeadTest02 {
    public static DeadTest02 VALUE = null;
    public static void isAlive(){
        if (VALUE!=null){
            System.out.println("Alive in now");
        }else {
            System.out.println("Dead in now");
        }
    }
    @Override
    protected void finalize()throws Throwable{
        super.finalize();
        System.out.println("搭上引用链的任一对象进行自救");
        VALUE = this;
    }

    public static void main(String[] args) {
        VALUE = new DeadTest02();
        System.out.println("开始第一次自救");
        VALUE = null;
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        isAlive();

        System.out.println("开始第二次自救");
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
