import java.util.ArrayList;
import java.util.Scanner;

public class ReadTester{
    public static void main(String[] args){
	ArrayList<Integer> list = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
	    while(true){
		System.out.print("Enter a space separeted list of numbers: ");
		String line = in.nextLine();
		Scanner lineScanner = new Scanner(line);
		while(lineScanner.hasNextInt()){
		    int temp = lineScanner.nextInt();
		    list.add(temp);
		}
		System.out.println(list.toString());
		list.clear();
	    }
    }
}
