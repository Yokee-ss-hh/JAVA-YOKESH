package SolidPrinciples.WithSolid;
// A class should have one, and only one reason to change.
interface IEmployeeRegistration{
    void getEmployeeName();
    void getEmployeeNumber();
}
interface IEmployeeRegistrationNotification{
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
}
class EmployeeRegistrationNotification implements IEmployeeRegistrationNotification{
    @Override
    public void sendMessage() {
        System.out.println("Sending registration successful message to employee");
    }
}
public class SingleResponsibilityPrinciple {
    public static void main(String[] args) {
        // EmployeeRegistration class has 2 responsibilities: getEmployeeName and getEmployeeNumber
        // EmployeeRegistrationNotification has 1 responsibility: sendMessage
    }
}
