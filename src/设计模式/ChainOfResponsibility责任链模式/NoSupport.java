package 设计模式.ChainOfResponsibility责任链模式;

public class NoSupport extends Support{
    public NoSupport(String name){
        super(name);
    }
    @Override
    protected boolean resolve(Trouble trouble) {
        return false;
    }
}
