#include <stdio.h>
#include <stdlib.h>
#include <time.h>

main()
{
	srand(time(NULL));
	int random;
	
	for(int counter=0;counter<10;counter++)
	{
		random= rand()  %  6  +  1;
		printf("The result of number is: %d\n", random);
	}
}
