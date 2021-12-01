package coreProgramming;

import java.time.LocalDate;

public class Employee {
    private String name;
    private double salary;

//    private LocalDate hireDay;

//    public Employee(String n,double s,int year,int month,int day){
    public Employee(String n,double s){
        name=n;
        salary=s;
//        hireDay=LocalDate.of(year,month,day);
    }
    public Employee(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
//    public LocalDate getHireDay(){
//        return hireDay;
//    }
    public void raiseSalary(double byPercent){
        double raise = salary*byPercent/100;
        salary+=raise;
    }

    //类中加main函数，对类进行单元测试的技巧
    public static void main(String[] args){
        Employee e = new Employee("Romeo",50000);
        e.raiseSalary(10);
        System.out.println(e.getName()+" "+e.getSalary());
    }
}
