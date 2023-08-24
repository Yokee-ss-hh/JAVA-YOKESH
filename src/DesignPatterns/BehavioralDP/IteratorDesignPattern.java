package DesignPatterns.BehavioralDP;
// Iterator pattern is used to provide a standard way to traverse through a group of Objects.
// There are 4 parts in this design pattern
// 1) Iterator interface:  Provide methods which concrete iterators must implement.
// 2) Concrete Iterator: Implements the Iterator interface methods. It can also keep track of the current position in the traversal of the aggregate collection.
// 3) Aggregate: It is typically a collection interface which defines a method that can create an Iterator object.
// 4) Concrete Aggregate: It implements the Aggregate interface and its specific method returns an instance of ConcreteIterator.

class Student{
    private String studentName;
    private Integer studentAge;
    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                '}';
    }
    public Student(String studentName, Integer studentAge){
        this.studentName = studentName;
        this.studentAge = studentAge;
    }
    public String getStudentName(){
        return studentName;
    }
    public Integer getStudentAge(){
        return studentAge;
    }
}
interface CustomIterator<T>{
    Boolean hasNext();
    T next();
    T currentItem();
    void reset();
}
class StudentIterator implements CustomIterator<Student>{
    private Integer position;
    private Student[] students;
    StudentIterator(Student[] students){
        this.students = students;
        position = 0;
    }
    @Override
    public Boolean hasNext() {
        return position < students.length;
    }
    @Override
    public Student next() {
        return students[position++];
    }
    @Override
    public Student currentItem() {
        return students[position];
    }
    @Override
    public void reset() {
        position = 0;
    }
}
interface StudentManager<E>{
    CustomIterator<E> getIterator();
}
class StudentsList implements StudentManager<Student>{
    Student[] students;
    StudentsList(Student[] students){
        this.students = students;
    }
    @Override
    public CustomIterator<Student> getIterator() {
        return new StudentIterator(students);
    }
}
public class IteratorDesignPattern {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("yokesh",23);
        students[1] = new Student("yoki",28);
        students[2] = new Student("yokee",33);
        students[3] = new Student("poki",19);
        students[4] = new Student("pokee",20);
        StudentsList studentIterator = new StudentsList(students);
        CustomIterator<Student> customIterator = studentIterator.getIterator();

        while(customIterator.hasNext()){
            System.out.println(customIterator.next());
        }
    }
}
