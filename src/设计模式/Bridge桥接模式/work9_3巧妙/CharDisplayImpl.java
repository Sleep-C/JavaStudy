package 设计模式.Bridge桥接模式.work9_3巧妙;

import 设计模式.Bridge桥接模式.DisplayImpl;

public class CharDisplayImpl extends DisplayImpl {
    private char head;
    private char body;
    private char foot;
    public CharDisplayImpl(char head,char body,char foot){
        this.body = body;
        this.foot = foot;
        this.head = head;
    }
    @Override
    public void rawOpen() {
        System.out.print(head);
    }

    @Override
    public void rawPrint() {
        System.out.print(body);
    }

    @Override
    public void rawClose() {
        System.out.println(foot);
    }
}
