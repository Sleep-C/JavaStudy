package 设计模式.Mediator中介者模式;

public interface Colleague {
    void setMediator(Mediator mediator);
    void setColleagueEnabled(boolean enabled);
}
