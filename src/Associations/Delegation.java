package Associations;
// Inheritance
class PrinterOne{
    public void printOne(){
        System.out.println("Printing...");
    }
}
class PrinterTwo extends PrinterOne{
    public void printTwo(){
        super.printOne();
    }
}

// Delegation 1
class PrinterThree{
    public void printThree(){
        System.out.println("Printing data...");
    }
}
class PrinterFour{
    PrinterThree printerThree;
    PrinterFour(PrinterThree printerThree){
        this.printerThree = printerThree;
    }
    public void printFour(){
        printerThree.printThree();
    }
}
// Delegation 2
interface Printer{
    public void print();
}
class HpPrinter implements Printer{
    @Override
    public void print() {
        System.out.println("Printing data using HP printer");
    }
}
class AdPrinter implements Printer{
    @Override
    public void print() {
        System.out.println("Printing data using Ad printer");
    }
}
class PrinterController implements Printer{
    Printer printer;
    PrinterController(Printer printer){
        this.printer = printer;
    }
    @Override
    public void print() {
        printer.print();
    }
}
public class Delegation {
    public static void main(String[] args) {
        PrinterTwo printerTwo = new PrinterTwo();
        printerTwo.printTwo();

        // printFour() method of PrintFour class is delegating request to printThree() method of PrintThree class
        PrinterFour printerFour = new PrinterFour(new PrinterThree());
        printerFour.printFour();

        // PrinterController is not responsible for the actual desired action but is actually
        // delegated to a helper class either CanonPrinter, AdPrinter.
        PrinterController printerController = new PrinterController(new HpPrinter());
        printerController.print();
        PrinterController printerController1 = new PrinterController(new AdPrinter());
        printerController1.print();
    }
}
