package Associations;
class Heart{
    Integer heartRate;
    Heart(Integer heartRate){
        this.heartRate = heartRate;
    }
    public void pumpBlood(){
        System.out.println("Pumping blood!!");
    }
    @Override
    public String toString() {
        return "Heart{" +
                "heartRate=" + heartRate +
                '}';
    }
}
class Human{
    String humanName;
    Heart heart;
    Human(String humanName){
        this.humanName = humanName;
        this.heart = new Heart(80);
        System.out.println(heart);
    }
    public void doRespiration(){
        heart.pumpBlood();
    }
    @Override
    public String toString() {
        return "Human{" +
                "humanName='" + humanName + '\'' +
                ", heart=" + heart +
                '}';
    }
}
public class Composition {
    public static void main(String[] args) {
        Human human = new Human("yokesh");
        System.out.println(human);
        // If human is dead, We cannot see heart is working/ not
        human = null;
        System.out.println(human);
        // As human is pointing to null, We cannot see heart is working/not
        // Heart cannot exist when human is dead. That means heart is a part of human
    }
}
