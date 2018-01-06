
import java.util.*;

public class Date{

    public static void main(String[] args) {

	GregorianCalendar cld = new GregorianCalendar(1995, 0, 20);
	System.out.println((cld.get(Calendar.MONTH)+1)+"/"+cld.get(Calendar.DAY_OF_MONTH)+"/"+cld.get(Calendar.YEAR));
	cld.add(cld.DAY_OF_MONTH, 20);
	System.out.println((cld.get(Calendar.MONTH)+1)+"/"+cld.get(Calendar.DAY_OF_MONTH)+"/"+cld.get(Calendar.YEAR));
	
    }
}
