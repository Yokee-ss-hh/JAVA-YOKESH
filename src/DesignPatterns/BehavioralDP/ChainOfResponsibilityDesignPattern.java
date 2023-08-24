package DesignPatterns.BehavioralDP;
// A Chain of Responsibility Pattern says that just "avoid coupling the sender of a request
// to its receiver by giving multiple objects a chance to handle the request".
interface CalculatorChain{
    public void setNextChain(CalculatorChain nextCalculatorChain);
    public void calculate(DataRequest dataRequest);
}
class DataRequest{
    private Integer number1;
    private Integer number2;
    private String calculationString;
    DataRequest(Integer number1, Integer number2, String calculationString){
        this.number1 = number1;
        this.number2 = number2;
        this.calculationString = calculationString;
    }
    public Integer getNumber1() {
        return number1;
    }
    public Integer getNumber2() {
        return number2;
    }
    public String getCalculationString() {
        return calculationString;
    }
}
class Addition implements CalculatorChain{
    private CalculatorChain calculatorChain;
    @Override
    public void setNextChain(CalculatorChain nextCalculatorChain) {
        this.calculatorChain = nextCalculatorChain;
    }
    @Override
    public void calculate(DataRequest dataRequest) {
        if(dataRequest.getCalculationString().equals("add")){
            System.out.println(dataRequest.getNumber1()+dataRequest.getNumber2());
        }
        else{
            calculatorChain.calculate(dataRequest);
        }
    }
}
class Subtraction implements CalculatorChain{
    private CalculatorChain calculatorChain;
    @Override
    public void setNextChain(CalculatorChain nextCalculatorChain) {
        this.calculatorChain = nextCalculatorChain;
    }
    @Override
    public void calculate(DataRequest dataRequest) {
        if(dataRequest.getCalculationString().equals("sub")){
            System.out.println(dataRequest.getNumber1()-dataRequest.getNumber2());
        }
        else{
            calculatorChain.calculate(dataRequest);
        }
    }
}
class Multiplication implements CalculatorChain{
    private CalculatorChain calculatorChain;
    @Override
    public void setNextChain(CalculatorChain nextCalculatorChain) {
        this.calculatorChain = nextCalculatorChain;
    }
    @Override
    public void calculate(DataRequest dataRequest) {
        if(dataRequest.getCalculationString().equals("mul")){
            System.out.println(dataRequest.getNumber1()*dataRequest.getNumber2());
        }
        else{
            calculatorChain.calculate(dataRequest);
        }
    }
}
class Division implements CalculatorChain{
    private CalculatorChain calculatorChain;
    @Override
    public void setNextChain(CalculatorChain nextCalculatorChain) {
        this.calculatorChain = nextCalculatorChain;
    }
    @Override
    public void calculate(DataRequest dataRequest) {
        if(dataRequest.getCalculationString().equals("div")){
            System.out.println(dataRequest.getNumber1()/dataRequest.getNumber2());
        }
        else{
            System.out.println("Incompatible operator found: Please provide any 1 of the following");
            System.out.println("1) add  2) sub  3) mul  4) div");
        }
    }
}
public class ChainOfResponsibilityDesignPattern {
    public static void main(String[] args) {
        CalculatorChain additionChain = new Addition();
        CalculatorChain subtractionChain = new Subtraction();
        CalculatorChain multiplicationChain = new Multiplication();
        CalculatorChain divisionChain = new Division();

        additionChain.setNextChain(subtractionChain);
        subtractionChain.setNextChain(multiplicationChain);
        multiplicationChain.setNextChain(divisionChain);

        DataRequest dataRequest = new DataRequest(12,21,"pov");
        additionChain.calculate(dataRequest);
    }
}
