package ExceptionsHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CheckedExceptions {

    // There are 3 ways to handle checked exceptions, They are:
    // If we don't use try/catch or method level throws keyword, java
    // raises compile time exception

    static void openFile1(){
        try {
            FileReader file = new FileReader("file.txt");
            BufferedReader br = new BufferedReader(file);
        }
        catch (Exception e){
            System.out.println(e.getClass());
        }
    }

    static void openFile2(){
        try {
            FileReader file = new FileReader("file.txt");
            BufferedReader br = new BufferedReader(file);
        }
        // If we know exception name we can replace "Exception" with "FileNotFoundException"
        catch (FileNotFoundException e){
            System.out.println(e.toString());
        }
    }

    static void openFile3() throws FileNotFoundException{
        FileReader file = new FileReader("file.txt");
        BufferedReader br = new BufferedReader(file);
    }
    public static void main(String[] args){
        openFile1();
        openFile2();
        try{
            openFile3();
        }
        catch (FileNotFoundException e){
            System.out.println(e.toString());
        }
    }
}
