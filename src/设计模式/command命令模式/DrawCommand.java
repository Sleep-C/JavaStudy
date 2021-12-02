package 设计模式.command命令模式;

import java.awt.*;

public class DrawCommand implements Command{
    protected Drawable drawable;
    private Point position;
    public DrawCommand(Drawable drawable, Point position){
        this.drawable = drawable;
        this.position = position;
    }
    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
