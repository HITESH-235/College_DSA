package College_DSA.TERM_II.OOPS_1_2;
public class ComplexNumber {
    float real, imaginary;

    ComplexNumber(float a, float b) {
        this.real = a;
        this.imaginary = b;
    }

    ComplexNumber add(ComplexNumber x) {
        return new ComplexNumber(x.real+real, x.imaginary+imaginary);
    }
}
