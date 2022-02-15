package Assignment;

import java.util.Scanner;

public class AreaOfTriangle {

       public static void main(String[] args) {
             // TODO Auto-generated method stub

             Scanner scan = new Scanner(System.in);
                System.out.println("Enter the base of the traingle :");
             double base =scan.nextDouble();
             System.out.println("Enter the height of the triangle :");
             double height =scan.nextDouble();
             double area =(base*height)/2;
             System.out.println("Area of triangle is:"+area);
             scan.close(); 

       }

}
