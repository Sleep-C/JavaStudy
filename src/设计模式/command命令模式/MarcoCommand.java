package 设计模式.command命令模式;

import java.util.Iterator;
import java.util.Stack;

public class MarcoCommand implements Command{
    private Stack commands = new Stack();
    @Override
    public void execute() {
        Iterator it = commands.iterator();
        while (it.hasNext()){
            ((Command)it.next()).execute();
        }
    }
    public void append(Command cmd){
        if (cmd != this){
            commands.add(cmd);
        }
    }
    public void undo(){
        if (!commands.empty()){
            commands.pop();
        }
    }
    public void clear(){
        commands.clear();
    }
}
