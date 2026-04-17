package HR;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee p1 = new FullTimeEmployee(1001240, "Bujar", "Berisha", LocalDate.of(1987,12,14), LocalDate.of(2016,01,01), 1340, 142);
        Employee p2 = new PartTimeEmployee(101202,"Xhevdet", "Krasniqi", LocalDate.of(1995, 10, 12),LocalDate.of(2026,02,15),15, 8,LocalDate.of(2026,06,06));
        FullTimeEmployee p3 = new FullTimeEmployee(1001112, "Valon", "Ajvazi", LocalDate.of(1996,12,24), LocalDate.of(2017,07,03), 1121, 105);
        PartTimeEmployee p4 = new PartTimeEmployee(101452,"Ismet", "Hajdari", LocalDate.of(1999, 04, 25),LocalDate.of(2025,04,10),24, 80,LocalDate.of(2027,04,10));
        FullTimeEmployee p5 = new FullTimeEmployee(1,"Filan", "Fisteku", LocalDate.of(1964,12,12),LocalDate.of(1984, 12, 12),3000, 500);



        System.out.println(p1.calculateSalary());
        System.out.println(p2.calculateSalary());
        System.out.println(p1);
        System.out.println(p2);
        System.out.println("Work Expirence: "+ p3.experience()+ " Years!");
        System.out.println("Retire Date: "+ p3.calculateRetirementDate());
        System.out.println(p4.getRemainingContractTime());
        System.out.println(p3.calculateSalary());
        System.out.println(p4.calculateSalary());
        List<Employee> employees = new ArrayList<>();
        employees.add(p1);
        employees.add(p2);
        employees.add(p3);
        employees.add(p4);
        employees.add(p5);

        for (Employee e: employees) {
            System.out.println("For Loop: "+ e.getFirstName() +" Salary: "+ e.calculateSalary());
        }

        p1.showEmployeeDetails();
    }
}
