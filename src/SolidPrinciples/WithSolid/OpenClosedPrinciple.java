package SolidPrinciples.WithSolid;
// Software entities should be open for extension, but closed for modification.
interface ICalculator{
    void perform();
}
class Add implements ICalculator{
    int n1,n2;
    Add(int n1, int n2){
        this.n1 = n1;
        this.n2 = n2;
    }
    @Override
    public void perform() {
        System.out.println(n1+n2);
    }
}
class Mul implements ICalculator{
    int n1,n2;
    Mul(int n1, int n2){
        this.n1 = n1;
        this.n2 = n2;
    }
    @Override
    public void perform() {
        System.out.println(n1*n2);
    }
}
class Sub implements ICalculator{
    int n1,n2;
    Sub(int n1, int n2){
        this.n1 = n1;
        this.n2 = n2;
    }
    @Override
    public void perform() {
        System.out.println(n1-n2);
    }
}
class Calculator implements ICalculator{
    private ICalculator calculator;
    Calculator(ICalculator iCalculator){
        calculator = iCalculator;
    }
    @Override
    public void perform() {
        calculator.perform();
    }
}
public class OpenClosedPrinciple {
    public static void main(String[] args) {
        ICalculator iCalculator = new Add(10,20);
        iCalculator.perform();
        iCalculator = new Sub(32,12);
        iCalculator.perform();
        iCalculator = new Mul(2,10);
        iCalculator.perform();
        // Here instead of modification of class everytime for new functionality
        // we are extending interface to create new functionality everytime.
    }
}
