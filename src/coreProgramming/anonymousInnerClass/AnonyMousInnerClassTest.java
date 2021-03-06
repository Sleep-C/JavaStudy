package coreProgramming.anonymousInnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class AnonyMousInnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1000,true);

        JOptionPane.showMessageDialog(null,"Quit program?");
        System.exit(0);
    }
    static class TalkingClock{
        public void start(int interval,boolean beep){
            ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("At the tone,the time is "+new Date());
                    if (beep) Toolkit.getDefaultToolkit().beep();
                }
            };
            Timer t=new Timer(interval,listener);
            t.start();
        }
    }
}
