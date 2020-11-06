import java.util.*;

public class Power {
        
   
    public static void main(String[] args) {
       int power,answer=0;
       double total;
       
       Scanner console=new Scanner (System.in);
       System.out.println("When you are done, please type -1.");
       while (answer!= -1)
       {
       	power=(int) (((12 -1 + 1)* Math.random()) +1);
       	total=Math.pow(2,power);
       	System.out.println("What is the answer for this: "+2+"^"+power);
       	answer=console.nextInt();
       	if (answer==total)
       		System.out.println("CORRECT!");
       	else
       	{
       		System.out.println("Pfft pathetic! Look at you!");
       		System.out.println("It is " + ((int) total));
       	}
       }
    }
}
