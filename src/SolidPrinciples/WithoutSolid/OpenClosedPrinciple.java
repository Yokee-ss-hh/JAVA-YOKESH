package SolidPrinciples.WithoutSolid;
// Software entities should be open for extension, but closed for modification.
class Calculator{
    int n1,n2;
    Calculator(int n1, int n2){
        this.n1 = n1;
        this.n2 = n2;
    }
    public void add(){
        System.out.println(n1+n2);
    }
    public void sub(){
        System.out.println(n1-n2);
    }
}
public class OpenClosedPrinciple {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(10,20);
        calculator.add();
        calculator.sub();
        // In future if I want to add 1 more functionality multiplication to Calculator class
        // Then I need to modify the Calculator class constructor, add new method mul()
        // After some days, Again I want division functionality....
        // Then I need to again modify the Calculator class constructor, add new method div()
        // This keeps on continuing everytime i want new functionality.
    }
}
