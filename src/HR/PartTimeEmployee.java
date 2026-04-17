package HR;

import java.time.LocalDate;
import java.time.Period;

public class PartTimeEmployee extends Employee {

    private double hourlyRate;
    private int hoursWorked;
    private LocalDate expireContractDate;

    public PartTimeEmployee (long employeeId, String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateOfHire, double hourlyRate, int hoursWorked, LocalDate expireContractDate) {
        super(employeeId, firstName, lastName, dateOfBirth, dateOfHire);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.expireContractDate = expireContractDate;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public LocalDate getExpireContractDate() {
        return expireContractDate;
    }

    public void setExpireContractDate(LocalDate expireContractDate) {
        this.expireContractDate = expireContractDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", HourlyRate: "+this.hourlyRate + " Euro,  i Have Worked: " + this.hoursWorked + " Hours this Month and My Contracact Expires at: "+ this.expireContractDate;
    }

    public String getRemainingContractTime() {
        Period period = Period.between(LocalDate.now(), getExpireContractDate());

        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        if (years > 0) {
            return years + " Years and " + months + " Months  and " + days  + " Days";
        }  else {
            return  months + " Months and " + days + " Days";
        }
    }
}
