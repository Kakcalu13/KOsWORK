import java.util.*;

public class RandomNumber {


	public static void main(String[] args) {
		int random,max,stop=0,flag=-1;
		Scanner console=new Scanner (System.in);
		
		System.out.print("1 to what: ");
		max=console.nextInt();
		System.out.println("If you are done with random generator, please press -1 to exit.");
		while (stop != flag)
		{	
			random=(int)(Math.random()*max-1+1);
			System.out.println("The number is: " + random);
			stop=console.nextInt();
			
			
		}
		
	}
}	