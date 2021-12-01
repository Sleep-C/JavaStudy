package coreProgramming;


/**
 * this program demonstrates inheritance
 * @version 1.21 2004-02-21
 * @author Cay Horstmann
 */
public class ManageTest {
    public static void main(String[] args){
        Manager boss = new Manager("Carl Cracker",80000,1987,12,15);
        boss.setBonus(5000);

        Employee3[] staff = new Employee3[3];
        staff[0] = boss;
        staff[1] = new Employee3("Harry Hacker",50000,1989,10,1);
        staff[2] = new Employee3("Tommy Tester",40000,1990,3,15);

        for (Employee3 e:staff)
            System.out.println("name="+e.getName()+",salary="+e.getSalary());
    }
}
