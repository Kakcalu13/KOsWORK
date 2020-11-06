import java.util.*;

public class KOloops {




    public static void main(String[] args) {
	int firstlevel=1, endlevel=1,midlevel=1,midEnd=3,lastlevel=1,lastEND=4,num=1,num1=1,x=1,c=4,d=1,z=1;
	
	while (lastlevel <= lastEND)
		{
			System.out.println();
			while (midlevel <= midEnd)
			{
				System.out.println();
				while (firstlevel <= endlevel)
				{
					System.out.print(num1 + " ");
					firstlevel++;
				}
				firstlevel=1;
				num1++;
				endlevel++;
				midlevel++;
			}
			lastlevel++;
			midEnd++;
			num1=num+1;
			num++;
			firstlevel=1;
			midlevel=1;
			endlevel=lastlevel;
		}
		
	while (z <= 3)
	{
	System.out.println();
	while (x < 4)
	{
		System.out.print(1);
		x++;
	}
	z++;
	x=1;
	
}
		
}

}