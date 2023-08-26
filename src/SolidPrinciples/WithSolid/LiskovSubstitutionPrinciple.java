package SolidPrinciples.WithSolid;
class Crow{
    public void eat(){
        System.out.println("crow is eating");
    }
    public void fly(){
        System.out.println("crow is flying");
    }
}
class Emu{
    public void eat(){
        System.out.println("emu is eating");
    }
    public void fly(){
        System.out.println("emu is flying");
    }
    public void sprint(){
        System.out.println("emu is sprinting");
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
class Ostrich extends Emu{
    @Override
    public void eat(){
        System.out.println("ostrich is eating");
    }
    @Override
    public void fly(){
        System.out.println("ostrich is flying");
    }
    @Override
    public void sprint(){
        System.out.println("ostrich is sprinting");
    }
}
public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        Crow crow = new Crow();
        crow.eat();
        crow.fly();

        Crow cuckoo = new Cuckoo();
        cuckoo.eat();
        cuckoo.fly();

        Emu emu = new Emu();
        emu.eat();
        emu.fly();
        emu.sprint();

        Emu ostrich = new Ostrich();
        ostrich.eat();
        ostrich.fly();
        ostrich.sprint();

        // We cannot extend Crow in Emu class even though both has eat() and fly() methods because
        // If Emu extends Crow for eat, fly methods it violates LSP because, I cannot substitute Emu
        // object to Crow class as,
        // Crow emu = new Emu();
        // Because Crow cannot sprint
        // Inorder to achieve this I am violating DRY
        // principle for LSP.
    }
}
