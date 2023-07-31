package ComparableAndComparator;

public class Employee implements Comparable<Employee> {
    String employeeName;
    int employeeAge;
    String employeeDesignation;

    Employee(String employeeName, int employeeAge, String employeeDesignation) {
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeDesignation = employeeDesignation;
    }

    @Override
    public int compareTo(Employee emp) {
        return this.employeeAge - emp.employeeAge;
    }

    @Override
    public String toString() {
        return String.format("%s : %s : %d", this.employeeName, this.employeeDesignation, this.employeeAge);
    }
}
