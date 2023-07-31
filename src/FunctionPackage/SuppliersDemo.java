package FunctionPackage;

import java.util.Arrays;
import java.util.function.*;

public class SuppliersDemo {
    public static void main(String[] args) {
        // Supplier<T> is an interface which has only 1 abstract method get() which returns 'T'.
        // Supplier don't take any input
        Supplier<String[]> stringSupplier = () -> {
            return new String[]{"java","python","c#"};
        };
        System.out.println(Arrays.toString(stringSupplier.get()));

        // IntSupplier does not take any input value and produces an output which is of type 'int'
        IntSupplier intSupplier = () -> {
            return 10;
        };
        System.out.println(intSupplier.getAsInt());

        // LongSupplier does not take any input value and produces an output which is of type 'long'
        LongSupplier longSupplier = () -> {
            return 121212121;
        };
        System.out.println(longSupplier.getAsLong());

        // DoubleSupplier does not take any input value and produces an output which is of type 'double'
        DoubleSupplier doubleSupplier = () ->{
            return 121.21212;
        };
        System.out.println(doubleSupplier.getAsDouble());

        // BooleanSupplier does not take any input value and produces an output which is of type 'boolean'
        BooleanSupplier booleanSupplier = () ->{
            return true;
        };
        System.out.println(booleanSupplier.getAsBoolean());

    }
}
