package coreProgramming;

import java.util.Arrays;
import java.lang.Object;

public class EmployeeSortTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Employee6[] staff = new Employee6[3];
        staff[0] = new Employee6("Harry Hacker",35000);
        staff[1] = new Employee6("Carl Cracker",75000);
        staff[2] = new Employee6("Tony Tester",38000);
        Employee6 test1 = new Employee6("Carl Cracker",75000);
        Employee6 testClone = test1.clone();
        Arrays.sort(staff);//对一个类的对象执行sort的前提是该类继承Comparable实现了compareTo
        for (Employee6 e:staff)
            System.out.println("name="+e.getName()+",salary="+e.getSalary());
    }
}
