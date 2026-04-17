package HR;

import java.time.LocalDate;
import java.time.Period;

public class FullTimeEmployee extends Employee {

    private double monthlySalary;
    private double bonus;

    @Override
    public double calculateSalary() {
        return monthlySalary + bonus;
    }

    public FullTimeEmployee(long employeeId, String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateOfHire, double monthlySalary, double bonus) {
        super(employeeId, firstName, lastName, dateOfBirth, dateOfHire);
        this.monthlySalary = monthlySalary;
        this.bonus = bonus;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", My Monthly Salary is: " + monthlySalary + " Euro plus " + bonus+ " Euro Bonus for this Month, so in Total: "+this.calculateSalary();
    }

    public LocalDate calculateRetirementDate() {
        return this.getDateOfBirth().plusYears(65);
    }
}
