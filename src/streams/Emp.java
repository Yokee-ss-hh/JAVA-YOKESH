package org.dsa.streams;

public class Emp {
    public int sal1;
    public int sal2;

    @Override
    public String toString() {
        return "Emp{" +
                "sal1=" + sal1 +
                ", sal2=" + sal2 +
                '}';
    }

    public Emp(int sal1, int sal2){
        this.sal1 = sal1;
        this.sal2 = sal2;
    }
}
