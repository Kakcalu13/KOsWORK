#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int random;
	
	for(int counter=0;counter<2;counter++)
	{
		random= rand()  %  6  +  1;
		printf("%d", 1 + (rand() % 6));
		return 0;
	}
}
