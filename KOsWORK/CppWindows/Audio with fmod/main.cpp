#include <stdlib.h>
#include <stdio.h>
#include <windows.h>

using namespace std;

int main ()
{
	printf("it began");
 	PlaySound("C:\\Users\\Dark Programmer\\Documents\\Programs file\\Codes\\C++ Codes\\Audio with fmod\\BeepCOOL.wav", NULL, SND_ASYNC);
 	
 	system("PAUSE");
 	return 0;
}
