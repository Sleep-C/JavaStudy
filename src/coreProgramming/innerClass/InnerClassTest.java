package coreProgramming.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000,true);
        clock.start();

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }

}
class TalkingClock{
    private int interval;
    private boolean beep;

    public TalkingClock(int interval,boolean beep){
        this.interval=interval;
        this.beep=beep;
    }
    public void start(){
//        class TimePrinter implements ActionListener{
//            public void actionPerformed(ActionEvent event){
//                System.out.println("At the tone,the time is "+new Date());
//                if (beep) Toolkit.getDefaultToolkit().beep();
//            }
//        }//局部内部类,作用域被局限在这个块中

        ActionListener listener = new TimePrinter();
        Timer t=new Timer(interval,listener);
        t.start();
    }
    public class TimePrinter implements ActionListener{
        public void actionPerformed(ActionEvent event){
            System.out.println("At the tone,the time is "+new Date());
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}

