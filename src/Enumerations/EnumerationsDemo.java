package Enumerations;


enum Shoe{
    SMALL("Suitable for kids",1000),
    MEDIUM("Suitable for all men",2000),
    LARGE("Suitable for oversizes",3000);

    // The below variables are declared as private final because
    // These can be modified if made public and not final
    // So that these can be accessed outside the enum and modification is possible
    private final String description;
    private final Integer price;

    @Override
    public String toString(){
        switch (this){
            case SMALL: return "SMALL SHOE";
            case MEDIUM: return "MEDIUM SHOE";
            case LARGE: return "LARGE SHOE";
            default: throw new IllegalArgumentException();
        }
    }

    Shoe(String description, Integer price){
        this.description = description;
        this.price = price;
    }

    String getDescription(){
        return this.description;
    }
    Integer getPrice(){
     return this.price;
    }
}
public class EnumerationsDemo {
    public static void main(String[] args) {
        Shoe shoeSize1 = Shoe.SMALL;
        System.out.println(shoeSize1);

        Shoe shoeSize2 = Shoe.MEDIUM;
        System.out.println(shoeSize2);

        Shoe shoeSize3 = Shoe.LARGE;
        System.out.println(shoeSize3);

        // ordinals
        System.out.println(shoeSize1.ordinal());
        System.out.println(shoeSize2.ordinal());
        System.out.println(shoeSize3.ordinal());

        // methods in enum class
        System.out.println(shoeSize1.getDescription());
        System.out.println(shoeSize1.getPrice());

        System.out.println(shoeSize2.getDescription());
        System.out.println(shoeSize2.getPrice());

        System.out.println(shoeSize3.getDescription());
        System.out.println(shoeSize3.getPrice());

        // getClass()
        System.out.println(shoeSize1.getClass());
        System.out.println(shoeSize2.getClass());
        System.out.println(shoeSize3.getClass());
        System.out.println(shoeSize1.getDeclaringClass()); // returns the class in which enum is declared

        System.out.println(shoeSize1.name());
        System.out.println(shoeSize1.compareTo(shoeSize2));
        System.out.println(shoeSize1.equals(shoeSize2));

        System.out.println(shoeSize1.toString()); // SMALL -> returns name of enum object by default
        // We can override this as
        System.out.println(shoeSize2.toString());
        System.out.println(shoeSize3.toString());

        Shoe[] shoes = Shoe.values();
        for(Shoe shoe: shoes){
            System.out.println(shoe.name());
        }

        // valueOf() takes already existing enum constant as a string and return it as a constant
        //
        System.out.println(Shoe.valueOf("SMALL")); // calls toString and uses its data
        // By default, if we don't override toString() it returns enum constant itself
    }
}
