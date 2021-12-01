package 设计模式.Singleton单例模式;

public class Main {
    public static void main(String[] args) {
        System.out.println("start.");
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        if (obj1 == obj2){
            System.out.println("obj1于obj2是相同的实例");
        }else {
            System.out.println("obj1于obj2是不同的实例");
        }
        System.out.println("End.");
    }
}
