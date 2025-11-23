package College_DSA.TERM_II.OOPS_1_2;

public class Rectangle {
    int L;
    int B;

    Rectangle(int L, int B) {
        this.L = L;
        this.B = B;
    }

    int perimeter() {
        return 2*(L+B);
    }

    int area() {
        return L*B;
    }
}
