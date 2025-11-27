package College_DSA.TERM_II.OOPS.OOPS_1_2;

class Car {
    public static void drive() {
        System.out.println("Driving...");
    }
}
class BMW extends Car {
    public static void drive() {
        System.out.println("Driving BMW");
    }
}
public class ModelQ extends BMW {
    public static void drive() {
        System.out.println("Driving ModelQ");
    }
    public static void main(String[] args) {
        // BMW a = new ModelQ();
        // a.drive(); // Output: Driving BMW
    }
    // Because the drive method is static and hence resolved at compile time
    // Hence it does not follows ModelQ's drive method
    // but follows BMW which is its reference type
}

// But for normal method if we override it in child class say in ModelQ
// then the ModelQ's non static method is chosen as it is done at runtime

// Calling of Overloaded methods is done at compile time
// Calling of Overridden methods is done at run time