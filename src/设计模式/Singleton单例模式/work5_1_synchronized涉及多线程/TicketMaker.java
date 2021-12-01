package 设计模式.Singleton单例模式.work5_1_synchronized涉及多线程;

public class TicketMaker {
    private int ticket = 1000;
    private static TicketMaker singleton = new TicketMaker();
    private TicketMaker(){

    }
    public static TicketMaker getInstance(){
        return singleton;
    }
    //定义为synchronized是为了防止多线程下返回相同编号
    public synchronized int getNextTicketNumber(){
        return ticket++;
    }
}
