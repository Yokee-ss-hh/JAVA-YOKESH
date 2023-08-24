package Reflection;

public class Dog {
    public String breedName;
    public String dogName;

    public Dog(String breedName, String dogName) {
        this.breedName = breedName;
        this.dogName = dogName;
    }

    public Dog(){}

    public String getBreedName(){
        return breedName;
    }
    public String getDogName(){
        return dogName;
    }
    public String mergeTwoDogs(String dog1, String dog2){
        return dog1+dog2;
    }
}
