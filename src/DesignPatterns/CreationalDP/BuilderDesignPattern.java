package DesignPatterns.CreationalDP;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.List;

// Builder pattern is used to create a complex object step by step
// The process of constructing an object should be generic so that
// it can be used to create different representations of the same object.
class Student{
    // mandatory fields
    private String firstName;
    private String lastName;
    private Integer age;
    // optional fields
    private List<String> courses;
    private String address;
    // Only getters to make the Student object immutable, Setters are not allowed
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Integer getAge() {
        return age;
    }
    public List<String> getCourses() {
        return courses;
    }
    public String getAddress() {
        return address;
    }
    private Student(EngineeringStudentBuilder studentBuilder) {
        this.firstName = studentBuilder.firstName;
        this.lastName = studentBuilder.lastName;
        this.age = studentBuilder.age;
        this.courses = studentBuilder.courses;
        this.address = studentBuilder.address;
    }
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", courses=" + courses +
                ", address='" + address + '\'' +
                '}';
    }
    public static class EngineeringStudentBuilder{
        // mandatory fields are set to final
        private final String firstName;
        private final String lastName;
        // If final fields are not initialized at the declaration itself, Then we need
        // to set them only once per object creation i.e, using constructor
        public EngineeringStudentBuilder(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }
        private Integer age;
        // optional fields are not set to final
        private List<String> courses;
        private String address;
        public EngineeringStudentBuilder setAge(Integer age) {
            this.age = age;
            return this;
        }
        public EngineeringStudentBuilder setCourses(List<String> courses) {
            this.courses = courses;
            return this;
        }
        public EngineeringStudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }
        public Student build(){
            return new Student(this);
        }
    }
}
public class BuilderDesignPattern {
    public static void main(String[] args) {
        // student1 object with all mandatory and optional information filled
        Student student1 = new Student.EngineeringStudentBuilder("yokesh","chowdary")
                .setAddress("pakala")
                .setAge(23)
                .setCourses(new ArrayList<>(List.of("maths","science"))).build();
        System.out.println(student1);
        // student2 object with only mandatory information filled
        Student student2 = new Student.EngineeringStudentBuilder("yoki","moki")
                .build();
        System.out.println(student2);
        // student3 object with all mandatory and 1 optional age parameter
        Student student3 = new Student.EngineeringStudentBuilder("yokee","mokee")
                .setAge(24)
                .build();
        System.out.println(student3);
    }
}
