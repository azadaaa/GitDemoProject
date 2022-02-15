package GetSetViewofKeys;


import java.util.Enumeration;
import java.util.Hashtable;

public class GetSetViewofKeys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		      Hashtable	 ht = new Hashtable();
		      ht.put("1", "One");
		      ht.put("2", "Two");
		      ht.put("3", "Three");
		      Enumeration e = ht.keys();

		      while (e.hasMoreElements()) {
		         System.out.println(e.nextElement());
		      }
		   }
		}
