package College_DSA.TERM_II.OOPS_3;

public class Static_Instance_Constructor {
    public static void main(String[] args) {
        Guess_Output obj = new Guess_Output();
        System.out.println(obj);
    }
}

class Guess_Output {
    Guess_Output() {
        System.out.print("Inside the Contructor \n");
    }
    {
        System.out.print("Inside the Instance block \n");
    }
    static {
        System.out.print("Inside the static block \n");
    }
}
