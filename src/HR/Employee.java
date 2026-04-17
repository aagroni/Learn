package HR;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public abstract class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfHire;

    public abstract double calculateSalary();

    public Employee(long employeeId, String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateOfHire) {
       if (employeeId <= 0 ) {throw new IllegalArgumentException("Employee ID must be greater than 0");}
       if (firstName == null || firstName.isEmpty()) {throw new IllegalArgumentException("First name cannot be empty");}
       if (lastName == null || lastName.isEmpty()) {throw new IllegalArgumentException("Last name cannot be empty");}
       if (dateOfBirth == null || dateOfHire == null) {throw new IllegalArgumentException("Date of birth cannot be empty");}

       LocalDate today = LocalDate.now();

       if (Period.between(dateOfBirth, dateOfHire).getYears() < 18 || Period.between(dateOfBirth, dateOfHire).getYears() > 65) {throw new IllegalArgumentException("Employee must be between 18 years and 65 years old at the time of hiring");}
        this.employeeId = employeeId;
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.dateOfBirth = dateOfBirth;
        this.dateOfHire = dateOfHire;
    }

    @Override
    public String toString() {
        return
                "ID: " + employeeId +
                " FirstName: " + firstName +
                ", LastName: " + lastName +
                ", BirthDay: " + dateOfBirth +
                ", Hired at: " + dateOfHire + " I'm "+ getAge() + " Years Old ";
    }

    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfHire() {
        return dateOfHire;
    }

    public void setDateOfHire(LocalDate dateOfHire) {
        this.dateOfHire = dateOfHire;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return employeeId == employee.employeeId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(employeeId);
    }

    public void showEmployeeDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("First Name: " + firstName);
    }

    public int experience() {
        return Period.between(getDateOfHire(), LocalDate.now()).getYears();
    }
}
