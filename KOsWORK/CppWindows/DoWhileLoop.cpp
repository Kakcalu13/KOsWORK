#include <stdio.h>
#include <math.h>

int main (int argc, char *argv[]) {
	
	int i=1000;
	
	do{	(i+=1); }
	while ((i%73) != 0);
	printf("%d",i);
}
