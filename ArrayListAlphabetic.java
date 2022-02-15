package ArrayListAlphabetic;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListAlphabetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		ArrayList<String> names = new ArrayList<String>();
		names.add("Ravi");
		names.add("Asif");
		names.add("Pavan");
		names.add("Manoj");
		names.add("Geetha");
		names.add("ABC");

		Collections.sort(names);
	    System.out.println(names);


	}

}
