package SolidPrinciples.WithoutSolid;
// The Liskov substitution principle states that an object of a superclass should be replaceable
// with any of its subclasses objects.
// The idea here is that the subtypes must be replaceable for the super type references without
// affecting the program execution.
class Crow{
    public void eat(){
        System.out.println("crow is eating");
    }
    public void fly(){
        System.out.println("crow is flying");
    }
}
class Cuckoo extends Crow{
    @Override
    public void eat(){
        System.out.println("cuckoo is eating");
    }
    @Override
    public void fly(){
        System.out.println("cuckoo is flying");
    }
}
class Ostrich extends Crow{
    @Override
    public void eat(){
        System.out.println("ostrich is eating");
    }
    @Override
    public void fly(){
        throw new UnsupportedOperationException("ostrich cannot fly");
    }
}
public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        Crow crow = new Crow();
        crow.eat();
        crow.fly();

        // I can successfully replace child object to super class reference
        Crow cuckoo = new Cuckoo();
        cuckoo.eat();
        cuckoo.fly();

        // Here I cannot successfully replace child object to super class reference
        Crow ostrich = new Ostrich();
        ostrich.eat();
        ostrich.fly(); // throws exception because ostrich cannot fly
    }
}
