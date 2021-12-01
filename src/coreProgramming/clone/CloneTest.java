package coreProgramming.clone;

public class CloneTest {
    public static void main(String[] args) {
        try {
            Employee original = new Employee("John Q.Public",50000);
            original.setHireDay(2000,1,1);
            Employee copy = original.clone();//如果没有catch部分，需要在main后面加throws CloneNotSupportedException
            copy.setHireDay(2002,12,31);
            System.out.println("original="+original);
            System.out.println("copy="+copy);
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
