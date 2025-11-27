package College_DSA.TERM_II.OOPS.OOPS_1_2;

public class Circle {
    float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    float perimeter() {
        return 2 * 3.14f * radius;
    }

    float area() {
        return 3.14f * radius * radius;
    }
}