package coreProgramming;

public class ConstructorTest {
    public static void main(String[] args){
        Employee2[] staff = new Employee2[3];
        staff[0] = new Employee2("Harry",40000);
        staff[1] = new Employee2(60000);
        staff[2] = new Employee2();
        for (Employee2 e:staff)
            System.out.println("name="+e.getName()+",id="+e.getId()+",salary="+e.getSalary());
    }
}
