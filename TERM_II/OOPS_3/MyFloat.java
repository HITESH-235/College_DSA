package College_DSA.TERM_II.OOPS_3;

public class MyFloat {
	int whole;
    int fraction;
		
    public MyFloat(int whole, int fraction) {
        this.whole = whole;
        this.fraction = fraction;
    }

    public MyFloat add(MyFloat other) {
        int w = other.whole + whole;
        int f = other.fraction += fraction;
        w += f/10;
        f %= 10;
        return new MyFloat(w, f);
    }
    
    public void printMyFloat(){
        // Print the MyFloat in the mentioned format
        System.out.println(whole+"."+fraction);
        return;
    }
}
