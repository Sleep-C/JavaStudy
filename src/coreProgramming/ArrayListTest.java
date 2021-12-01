package coreProgramming;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Employee5> staff = new ArrayList<>();
        staff.add(new Employee5("Carl Cracker",75000,1987,12,15));
        staff.add(new Employee5("Harry Hacker",50000,1989,10,1));
        staff.add(new Employee5("Tony Tester",40000,1990,3,15));

        for (Employee5 e:staff)
            e.raiseSalary(5);

        for (Employee5 e:staff)
            System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="+e.getHireDay());

    }
}
