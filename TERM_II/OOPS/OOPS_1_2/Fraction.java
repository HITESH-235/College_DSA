package College_DSA.TERM_II.OOPS.OOPS_1_2;

public class Fraction {
    int num, denom;
    public Fraction(int num, int denom) {
        if (denom < 0) {
            num = -num;
            denom = -denom;
        }

        this.num = num;
        this.denom = denom;
    }

    Fraction add(Fraction A) {
        int n = A.num * denom + A.denom * num;
        int d = A.denom * denom;

        return simplify(n,d);
    }

    Fraction subtract(Fraction A) {
        int n = A.denom * num - A.num * denom;
        int d = A.denom * denom;

        return simplify(n,d);
    }

    Fraction multiply(Fraction A) {
        int n = A.num * num;
        int d = A.denom * denom;

        return simplify(n,d);
    }

    Fraction simplify(int n, int d) {
        int x = gcd(n,d);
        n /= x;
        d /= x;
        return new Fraction(n, d);
    }

    int gcd (int n, int d) {
        n = Math.abs(n);
        d = Math.abs(d);

        while (d!=0) {
            int temp = d;
            d = n%d;
            n = temp;
        }
        return n;
    }

    @Override
    public String toString() {
        if (denom == 1) return String.valueOf(num); // Prints "5" instead of "5/1"
        return num + "/" + denom;
    }

public static void main(String[] args) {
    // Test Case 1: Basic Addition (1/2 + 1/3)
    Fraction f1 = new Fraction(1, 2);
    Fraction f2 = new Fraction(1, 3);
    
    Fraction f3 = f1.add(f2);
    System.out.println(f1 + " + " + f2 + " = " + f3); 

    Fraction f4 = new Fraction(5, 6);
    Fraction f5 = new Fraction(1, 6);
    
    Fraction f6 = f4.subtract(f5);
    System.out.println(f4 + " - " + f5 + " = " + f6);

    // Test Case 3: Multiplication (3/4 * 2/3)
    Fraction f7 = new Fraction(3, 4);
    Fraction f8 = new Fraction(2, 3);
    
    Fraction f9 = f7.multiply(f8);
    System.out.println(f7 + " * " + f8 + " = " + f9);

    Fraction f10 = new Fraction(4, -8);
    System.out.println("Negative Simplification: " + f10);
}
}
