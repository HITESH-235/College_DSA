package College_DSA.TERM_II.OOPS_1_2;

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


// More Small MCQ questions:

class Student {
    int age;
    String name;

    void display(){
        System.out.println("My name is " + this.name + ". I am "  + this.age + " years old");
    }
}

class Client {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.age = 10;
        s1.name = "A";
        s1.display();

        Student s2 = s1;
        s2.age = 20;
        s2.name = "B";

        s2.display(); // My name is B. I am 20 years old
        s1.display(); // My name is B. I am 20 years old
    }
}