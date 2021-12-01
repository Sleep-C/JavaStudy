package coreProgramming.clone;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable{
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String n,double s){
        name=n;
        salary=s;
        hireDay= new Date();
    }

    public Employee clone() throws CloneNotSupportedException{
        Employee cloned = (Employee)super.clone();
        cloned.hireDay = (Date)hireDay.clone();
        return cloned;
    }
    public void setHireDay(int y,int m,int d){
        Date newHireDay = new GregorianCalendar(y,m-1,d).getTime();
        hireDay.setTime(newHireDay.getTime());
    }
    public void raiseSalary(double byPercent){
        double raise = salary*byPercent/100;
        salary+=raise;
    }
    public String toString(){
        return "Employee[name="+name+",salary="+salary+",hireDay"+hireDay+"]";
    }
}
