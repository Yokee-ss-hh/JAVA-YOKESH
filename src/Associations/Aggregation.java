package Associations;

class Car{
    String carType;
    String carId;
    Car(String carType, String carId){
        this.carType = carType;
        this.carId = carId;
    }
    @Override
    public String toString() {
        return "Car{" +
                "carType='" + carType + '\'' +
                ", carId='" + carId + '\'' +
                '}';
    }
}
class Person{
    String personName;
    Integer personAge;
    final Car car;
    public Person(String personName, Integer personAge, Car car) {
        this.personName = personName;
        this.personAge = personAge;
        this.car = car;
    }
    @Override
    public String toString() {
        return "Person{" +
                "personName='" + personName + '\'' +
                ", personAge='" + personAge + '\'' +
                ", car=" + car +
                '}';
    }
}
public class Aggregation {
    public static void main(String[] args) {
        Car car = new Car("brezaa vxi","p92cxmg23");
        Person person = new Person("yokesh",23,car);
        System.out.println(car);
        System.out.println(person);
        // Person object has Car object as instance type
        // If Person object is dead, The Car object can still exist as there is a week relationship
        // between Person object and Car object
        person = null;
        System.out.println(person); // Person object is dead
        System.out.println(car); // Car object is still alive
    }
}
