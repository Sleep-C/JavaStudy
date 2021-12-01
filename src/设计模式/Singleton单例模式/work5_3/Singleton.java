package 设计模式.Singleton单例模式.work5_3;

public class Singleton {
    private static Singleton singleton = null;
    private Singleton(){
        System.out.println("生成了一个实例。");
    }
    //不使用synchronized在多线程下，可能出现多个函数先后通过==null判断，造成构造了多个函数
    //保证同一时刻最大只有一个线程执行同步代码
    public static synchronized  Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
