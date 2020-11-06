#include <stdio.h>

main()
{
	double grade=0;
	
	printf("Please enter test score: ");
	scanf("%lf",&grade);
	
	if (grade > 70) {
		printf("Good job! You da man!");
	}
	else
	{
		printf("damn, you suck!!");
	}
	return 0;
}
