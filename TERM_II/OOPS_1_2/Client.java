// Object Reference behaviour, one object, two variables

// Here we dont create a new student object, but rather a reference s2
// it points to the first object already instantiated

// since objects are stored in heap memory
// vars like s1 and s2 are just pointers(references) to the same object
// any change made via s2 will reflect when accessed via s1

package College_DSA.TERM_II.OOPS_1_2;
class Student {
    int age;
    String name;

    void display(){
        System.out.println("My name is " + this.name + ". I am "  + this.age + " years old");
    }
}

public class Client {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.age = 10;
        s1.name = "A";
        s1.display(); // My name is A. I am 10 years old

        Student s2 = s1;
        s2.age = 20;
        s2.name = "B";

        s2.display(); // My name is B. I am 20 years old
        s1.display(); // My name is B. I am 20 years old
    }
}

// Else if you want to make an Explicit Copy add this contructor in Student
// Student(Student other) {
//     this.age = other.age;
//     this.name = other.name;
// }
// And then you can call this directly to make an explicit copy:
// Student s2 = new Student(s1);
// this creates a "deep" copy of s1 into s2 (completely duplicate)

// a "shallow" copy can be created like this:
// Student s2 = new Student();
// s2.name = s1.name;
// s2.age = s1.age;