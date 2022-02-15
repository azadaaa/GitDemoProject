package HigestAndLowestTreeSet;


import java.util.*;

public class HigestAndLowestTreeSet {
    public static void main(String args[])
    {

        TreeSet<Integer> set = new TreeSet<Integer>(); 
        set.add(13);
        set.add(86);
        set.add(71);
        set.add(91);
        set.add(80);
        set.add(40);
        set.add(100);
        set.add(12);

        System.out.println("Elements of the treeset are: " + set);


        System.out.println("Highest Value: " + set.pollLast()); 

        System.out.println("Lowest Value: " + set.pollFirst());

        }       
}
