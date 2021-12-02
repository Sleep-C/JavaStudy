package 设计模式.command命令模式;

import java.awt.*;

public class DrawCanvas extends Canvas implements Drawable {
    private Color color = Color.red;
    private int radius = 6;
    private MarcoCommand history;
    public DrawCanvas(int width, int height, MarcoCommand history){
        setSize(width,height);
        setBackground(Color.white);
        this.history = history;
    }
    public void paint(Graphics g){
        history.execute();
    }
    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius*2, radius*2);
    }
}
