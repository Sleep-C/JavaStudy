package coreProgramming;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class p96p102系统类 {
    public static void main(String[] args ) throws InterruptedException {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        date = date.minusDays(today-1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i=0;i<value;i++){
            System.out.print("   ");
        }
        while (date.getMonthValue() == month){
            System.out.printf("%3d",date.getDayOfMonth());
            if (date.getDayOfMonth() == today){
                System.out.print("*");
            }else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1)System.out.println();
        }
        if (date.getDayOfWeek().getValue()!=1)System.out.println();


//        LocalDate newyear=LocalDate.now();
//        System.out.println(newyear);//两种不同的表示时间方式yyyy-mm-dd
//        int year=newyear.getYear();

//        Date birthday=new Date();
//        Date deadline=birthday;
//        System.out.println(birthday);
//        Thread.sleep(1000);//改变deadline不影响birthday
//        deadline=new Date();
//        System.out.println(birthday);
//        System.out.println(deadline);
    }
}
