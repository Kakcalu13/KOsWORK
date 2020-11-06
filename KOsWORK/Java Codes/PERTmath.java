import java.util.*;


public class PERTmath {
	
public static void main(String[] args){
	Scanner console=new Scanner (System.in);
	double borrow=0, interest=0, e=2.71828,day=0, total=0, year=0;
	String date;	
	
	System.out.print("How many money did you borrowed: ");
	borrow=console.nextDouble();
	System.out.print("How many of interest(decimal): ");
	interest=console.nextDouble();
	System.out.print("How long is this, y/d: ");
	date=console.next();
	
	if (date.charAt(0)== 'y')
	{
		System.out.print("how many of years?: ");
		year=console.nextInt();
		total= (borrow*Math.pow(e,(interest*year)));
	}
	else if (date.charAt(0) == 'd')
	{
		System.out.print("How many of days?: ");
		day=console.nextDouble();
		day=(day/365);
		total=(borrow*Math.pow(e,(interest*day)));
	}
    
    System.out.println("The total is: $" + total);
}
}