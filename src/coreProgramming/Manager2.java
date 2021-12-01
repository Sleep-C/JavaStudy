package coreProgramming;

public class Manager2 extends Employee5{
    private double bonus;
    public Manager2(String name,double salary,int year,int month,int day){
        super(name,salary,year,month,day);
        bonus=0;
    }
    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
    public void setBonus(double aBonus){
        bonus=aBonus;
    }
    public boolean equals(Object otherObject){
        if (!super.equals(otherObject)) return false;
        Manager2 other = (Manager2)otherObject;
        return bonus==other.bonus;
    }
    public int hashCode(){
        return super.hashCode()+17*new Double(bonus).hashCode();
    }
    public String toString(){
        return super.toString()+"[bonus="+bonus+"]";
    }
}
