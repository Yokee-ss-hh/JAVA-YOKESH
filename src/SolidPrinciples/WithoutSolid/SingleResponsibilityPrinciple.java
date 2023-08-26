package SolidPrinciples.WithoutSolid;
interface IEmployeeRegistration{
    void getEmployeeName();
    void getEmployeeNumber();
    void sendMessage();
}
class EmployeeRegistration implements IEmployeeRegistration{
    @Override
    public void getEmployeeName() {
        System.out.println("Getting employee name from employee");
    }
    @Override
    public void getEmployeeNumber() {
        System.out.println("Getting employee number from employee");
    }
    @Override
    public void sendMessage() {
        System.out.println("sending email confirmation");
    }
}
public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        // The problem here is:
        // EmployeeRegistration class is in sync with getEmployeeName and getEmployeeNumber methods
        // as these 2 methods are essential for any employee registration. But,sendConfirmationEmail
        // should not be in EmployeeRegistration class. Because, the responsibility of EmployeeRegistration
        // class is get employee details and save them to DB but not to send confirmation email to
        // employee.
        // This example violates "Single Responsibility Principle".
    }
}
