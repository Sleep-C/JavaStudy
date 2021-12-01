package coreProgramming;

import java.util.Random;

public class Employee2 {
    private static int nextId;

    private int id;
    private String name="";//instance field initialization
    private double salary;

    //static initialization block
    static {
        Random generator = new Random();
        //set nextId to a random number between 1 and 9999
        nextId = generator.nextInt(10000);
    }

    //object initialization block
    {
        id=nextId;
        nextId++;
    }
    //three overloaded constructors
    public Employee2(String aName,double aSalary){
        name=aName;
        salary=aSalary;
    }
    public Employee2(double s){
        //calls the Employee2(String,double) constructor
        this("Employee2 #"+nextId,s);
    }
    //the default constructor
    public Employee2(){
        //nema=""
        //salary=0
        //id initialized in initialization block
//        this("123",11111);
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public int getId(){
        return id;
    }
}
