public class AssertTester{
    public static void main(String[] args){
	Term fail = new Term(2.0, -5);
	Term succ = new Term();
	System.out.println("Empty polynomial:");
	System.out.println(succ.toString());
	succ = new Term(2.0, 2);
	System.out.println("non-Empty polynomial:");
	System.out.println(succ.toString());
    }
}
