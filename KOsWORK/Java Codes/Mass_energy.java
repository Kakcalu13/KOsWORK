import java.util.*;

public class Mass_energy {
	
public static void main(String[] args){
	double answer,m,c;
	Scanner console=new Scanner (System.in);
	
	System.out.println("E=mc^2");
	System.out.print("Mass: ");
    m=console.nextDouble();
    System.out.print("Speed of light(c): ");
    c=console.nextDouble();
    System.out.println("Ok, so this is E="+m+"*"+c+"^2");
    answer=m*Math.pow(c,2);
    System.out.println("The answer is: " + answer + " Joules");
    
}
}