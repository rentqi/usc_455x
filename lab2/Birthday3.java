
import java.util.*;

public class Birthday3 {

    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.println("Enter your birth month[1...12]:");
	int month = in.nextInt();
	System.out.println("Enter your birth day of month:");
	int day = in.nextInt();
	System.out.println("Enter your birth year [4-digit year]:");
	int year = in.nextInt();
	GregorianCalendar cld = new GregorianCalendar(year, month, day);
	Calendar now = GregorianCalendar.getInstance();
        int age = now.get(Calendar.YEAR)-cld.get(Calendar.YEAR)-1;
	if(cld.get(Calendar.MONTH)-1>now.get(Calendar.MONTH)){
	    System.out.println("Your birthday has not yet happened.");
	}else if(cld.get(Calendar.MONTH)-1<now.get(Calendar.MONTH)){
	    System.out.println("Your birthday has already happened.");
	    age+=1;
	}else{
	    if(cld.get(Calendar.DAY_OF_MONTH)>now.get(Calendar.DAY_OF_MONTH)){
		System.out.println("Your birthday has not yet happened.");
	    }else{
		System.out.println("Your birthday has already happened.");
	        age+=1;
	    }
	}
	System.out.println("You're "+age+" years old.");

    }
}

