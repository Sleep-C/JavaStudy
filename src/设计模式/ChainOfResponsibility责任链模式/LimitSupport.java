package 设计模式.ChainOfResponsibility责任链模式;

public class LimitSupport extends Support{
    private int limit;
    public LimitSupport(String name,int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(Trouble trouble) {
        if (trouble.getNumber() < limit){
            return true;
        }else {
            return false;
        }
    }
}
