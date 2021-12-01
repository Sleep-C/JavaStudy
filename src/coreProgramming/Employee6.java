package coreProgramming;

public class Employee6 implements Comparable<Employee6> ,Cloneable{
    private String name;
    private double salary;

    public Employee6(String n,double s){
        name=n;
        salary=s;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }

    public void raiseSalary(double byPercent){
        double raise = salary*byPercent/100;
        salary+=raise;
    }

    @Override
    public Employee6 clone() throws CloneNotSupportedException{
        return (Employee6)super.clone();
    }

    @Override
    public int compareTo(Employee6 other) {
        return Double.compare(salary,other.salary);
    }
}
